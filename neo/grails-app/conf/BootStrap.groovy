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
		
		def userSec = new Usuario(
			username:'camila',
			userRealName : 'camila',
			enabled : true,
			email : 'camilaXYZ@gmail.com',
			passwd : authenticateService.encodePassword('camila'));
	
		
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
		if (!userSec.hasErrors()) {
			userSec.save()
			roleUser.addToPeople(userSec)
		} else {
			println "Usuario secretaria com erros!"
		}
		
		roleManutencao.save()
		roleAdmin.save()
		roleUser.save()
					
	}
	
	def destroy = {
	}
} 