
class LoginTests extends functionaltestplugin.FunctionalTestCase {
	private String defaultLocation =  "http://localhost:9000/NEOSoftGrails/login/auth";
	
	void testAnonymousAccess() {
		get(this.defaultLocation);
		assertContentContains("Digite login e senha")
	}
	
	void testManutencaoAccess(){
		
		get(this.defaultLocation);
		form('loginForm') {
			j_username = "manutencao"
			j_password = "admin"
			click "OK"
		}
		
		assertStatus 200
		assertContentContains "Equipe de Manutencao, bem vindo ao SI Neo!"
	}
	
	void testMedicoAccess(){
		get(this.defaultLocation);
		form('loginForm') {
			j_username = "harrison"
			j_password = "harrison"
			click "OK"
		}
		
		assertStatus 200
		assertContentContains "Harrison, bem vindo ao SI Neo!"
	}
	
	void testSecretariaAccess(){
		get(this.defaultLocation);
		form('loginForm') {
			j_username = "camila"
			j_password = "camila"
			click "OK"
		}
		
		assertStatus 200
		assertContentContains "Camila, bem vindo ao SI Neo!"
		
		click "linkopcoes"
		click "linkusuario"
		assertContentContains "acesso insuficiente"
		
	}
	
	void testUnsuccessfullAccess(){
		get(this.defaultLocation);
		form('loginForm') {
			j_username = "camila"
			j_password = "outropasswd"
			click "OK"
		}
		
		
		assertContentContains "Nome ou senha invalidos."
		
	}
	
}
