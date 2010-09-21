
class LoginTests extends functionaltestplugin.FunctionalTestCase {
	private String defaultLocation =  "http://localhost:9000/NEOSoftGrails/login/auth";
	void testAnonymousAccess() {
			get(this.defaultLocation);
			assertContentContains("Digite login e senha")
									
    }
	
	void testManutencaoAccess(){

		get(this.defaultLocation);
		assertContentContains("Digite login e senha")

		form('loginForm') {
			j_username = "manutencao"
			j_password = "admin"
			click "OK"
		  }
		
		assertStatus 200
		assertContentContains "Equipe de Manutencao, bem vindo ao SI Neo!"
	}
	
	
}
