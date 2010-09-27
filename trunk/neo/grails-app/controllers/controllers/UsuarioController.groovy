package controllers

import acesso.Hierarquia;
import acesso.Usuario;

/**
 * Controladora de usuarios, classe gerada no plugin Acegi. Controla as atividades de CRUD sob
 * os usuarios do sistema
 * 
 * @see acesso.Usuario
 */
class UsuarioController {	// TODO traduzir frases
	def authenticateService
	def acessoService
	
	// the delete, save and update actions only accept POST requests
	static Map allowedMethods = [delete: 'POST', save: 'POST', update: 'POST']
	
	/**
	 * Acao executada ao acessar /usuario.
	 */
	def index = {
		redirect action: list, params: params
	}
	
	/**
	 * Acao para abertura do formulario.
	 */
	def alterarSenha = {
	}
	
	/**
	 * Acao para alteracao de senha, ao submeter formulario.
	 */
	def doAlterarSenha = {
		try {
			acessoService.alterarSenha(params.senhaAtual, params.novaSenha);
			flash.message = "Senha alterada com sucesso!"
		} catch (Exception e) {
			flash.message = "Senha atual invalida!"
		}
		redirect action : alterarSenha
	}
	
	/**
	 * Acao para listagem de usuarios.
	 */
	def list = {
		if (!params.max) {
			params.max = 10
		}
		[personList: Usuario.list(params)]
	}
	
	/**
	 * Acao para exibicao de dados de um usuario especifico.
	 */
	def show = {
		def person = Usuario.get(params.id)
		if (!person) {
			flash.message = "Usuario nao encontrado com id $params.id"
			redirect action: list
			return
		}
		List roleNames = []
		for (role in person.authorities) {
			roleNames << role.authority
		}
		roleNames.sort { n1, n2 ->
			n1 <=> n2
		}
		[person: person, roleNames: roleNames]
	}
	
	/**
	 * Acao para deletar um usuario. Um usuario nao pode se deletar.
	 */
	def delete = {
		def person = Usuario.get(params.id)
		if (person) {
			def authPrincipal = authenticateService.principal()
			//avoid self-delete if the logged-in user is an admin
			if (!(authPrincipal instanceof String) && authPrincipal.username == person.username) {
				flash.message = "Voce não pode deletar você mesmo do sistema"
			}
			else {
				//first, delete this person from People_Authorities table.
				Hierarquia.findAll().each { it.removeFromPeople(person)
				}
				person.delete()
				flash.message = "Usuario $params.id deletado."
			}
		}
		else {
			flash.message = "Usuario nao encontrado com id $params.id"
		}
		
		redirect action: list
	}
	
	/**
	 * Acao para edicao de usuarios.
	 */
	def edit = {
		def person = Usuario.get(params.id)
		if (!person) {
			flash.message = "Usuario nao encontrado com id $params.id"
			redirect action: list
			return
		}
		
		return buildPersonModel(person)
	}
	
	/**
	 * Acao para atualizar usuario, ao submeter formulario de edicao.
	 */
	def update = {
		def person = Usuario.get(params.id)
		if (!person) {
			flash.message = "Usuario nao encontrado com id $params.id"
			redirect action: edit, id: params.id
			return
		}
		
		long version = params.version.toLong()
		if (person.version > version) {
			person.errors.rejectValue 'version', "person.optimistic.locking.failure",
			"Outra pessoa estava atualizando este usuario enquanto voce editava"
			render view: 'edit', model: buildPersonModel(person)
			return
		}
		
		def oldPassword = person.passwd
		person.properties = params
		if (!params.passwd.equals(oldPassword)) {
			person.passwd = authenticateService.encodePassword(params.passwd)
		}
		if (person.save()) {
			Hierarquia.findAll().each { it.removeFromPeople(person)
			}
			addRoles(person)
			redirect action: show, id: person.id
		}
		else {
			render view: 'edit', model: buildPersonModel(person)
		}
	}
	
	/**
	 * Acao para criar usuario.
	 */
	def create = {
		[person: new Usuario(params), authorityList: Hierarquia.list()]
	}
	
	/**
	 * Acao para salvar usuario, ao submeter formulario de criacao.
	 */
	def save = {
		def person = new Usuario()
		person.properties = params
		person.passwd = authenticateService.encodePassword(params.passwd)
		if (person.save()) {
			addRoles(person)
			redirect action: show, id: person.id
		}
		else {
			render view: 'create', model: [authorityList: Hierarquia.list(), person: person]
		}
	}
	
	private void addRoles(person) {
		for (String key in params.keySet()) {
			if (key.contains('ROLE') && 'on' == params.get(key)) {
				Hierarquia.findByAuthority(key).addToPeople(person)
			}
		}
	}
	
	private Map buildPersonModel(person) {
		
		List roles = Hierarquia.list()
		roles.sort { r1, r2 ->
			r1.authority <=> r2.authority
		}
		Set userRoleNames = []
		for (role in person.authorities) {
			userRoleNames << role.authority
		}
		LinkedHashMap<Hierarquia, Boolean> roleMap = [:]
		for (role in roles) {
			roleMap[(role)] = userRoleNames.contains(role.authority)
		}
		
		return [person: person, roleMap: roleMap]
	}
}
