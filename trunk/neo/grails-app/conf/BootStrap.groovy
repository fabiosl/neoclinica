import acesso.Hierarquia;
import acesso.Usuario;

class BootStrap {
	def authenticateService
	
	def init = { servletContext ->
		def roleManutencao = new Hierarquia(authority:'ROLE_MANUTENCAO', description:'Equipe de manutencao')
		def roleAdmin = new Hierarquia(authority:'ROLE_ADMIN', description:'Administradores do sistema')
		def roleUser  = new Hierarquia(authority:'ROLE_FUNCIONARIO', description:'Funcionarios da clinica')
		
		def userGod = new Usuario(
		username:'manutencao',
		userRealName :'Equipe de Manutencao',
		enabled : true,
		email : '',
		passwd : authenticateService.encodePassword('admin'));
		
		roleManutencao.save()
		roleAdmin.save()
		roleUser.save()
		
		if (!userGod.hasErrors()) {
			userGod.save()
			roleManutencao.addToPeople(userGod)
		} else {
			println "Usuario default com erros!"
		}
	}
	
	def destroy = {
	}
} 