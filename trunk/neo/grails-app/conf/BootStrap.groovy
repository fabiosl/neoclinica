import acesso.Hierarquia;
import acesso.Usuario;
import core.Medico 

class BootStrap {
	def authenticateService
	
	def init = { servletContext ->
		// marcar como true no primeiro run apos as tabelas terem sido criadas
		final boolean CRIAR_USUARIOS = true;
		
		if (CRIAR_USUARIOS) {
			def userGod = new Usuario(
			username:'manutencao',
			userRealName :'Equipe de Manutencao',
			enabled : true,
			email : '',
			passwd : authenticateService.encodePassword('admin'));
			userGod.save();
			
			def userMed = new Medico(
			username:'harrison',
			userRealName : 'Harrison Sarmento',
			enabled : true,
			email : 'harrison73oft@gmail.com',
			passwd : authenticateService.encodePassword('harrison'),
			crm: null,
			especialidade : null);
			userMed.save();
			
			def userSec = new Usuario(
			username:'camila',
			userRealName : 'camila',
			enabled : true,
			email : 'camilaXYZ@gmail.com',
			passwd : authenticateService.encodePassword('camila'));
			userSec.save();
			
			def roleManutencao = new Hierarquia(authority:'ROLE_MANUTENCAO', description:'Equipe de manutencao')
			roleManutencao.addToPeople(userGod)
			roleManutencao.save()
			
			def roleAdmin = new Hierarquia(authority:'ROLE_ADMIN', description:'Administradores do sistema')
			roleAdmin.addToPeople(userMed)
			roleAdmin.save()
			
			def roleUser  = new Hierarquia(authority:'ROLE_FUNCIONARIO', description:'Funcionarios da clinica')
			roleUser.addToPeople(userSec)
			roleUser.save()
		}
	}
	
	def destroy = {
	}
} 