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
		
		def userMed = new Usuario(
			username:'harrison',
			userRealName : 'Harrison',
			enabled : true,
			email : 'harrison73oft@gmail.com',
			passwd : authenticateService.encodePassword('harrison'));
	
	
		roleManutencao.save()
		roleAdmin.save()
		roleUser.save()
				
		if (!userGod.hasErrors()) {
			userGod.save()
			roleManutencao.addToPeople(userGod)
		} else {
			println "Usuario de manutencao com erros!"
		}
		
		if (!userMed.hasErrors()) {
			userMed.save()
			roleAdmin.addToPeople(userMed)
		} else {
			println "Usuario administrador com erros!"
		}
		
		
		
		
	}
	
	def destroy = {
	}
} 