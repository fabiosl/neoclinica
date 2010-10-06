
class CRUDUsuarioTests extends functionaltestplugin.FunctionalTestCase {
	private String defaultLocation =  "http://localhost:9000/NEOSoftGrails/login/auth";
	
	void testAddUsuarioOK() {
		get(this.defaultLocation);
		form('loginForm') {
			j_username = "harrison"
			j_password = "harrison"
			click "OK"
		}
	}	
	
	void testAddUsuarioNotOk() {
		//Testa adicionar usuario logando sem privilegio para isso.
		get(this.defaultLocation);
		form('loginForm') {
			j_username = "camila"
			j_password = "camila"
			click "OK"
		}
		
		click "linkopcoes"
		
		assertContentContains "Controle de Usuarios"
	}
	
	void testRemoveUsuarioOK() {
		get(this.defaultLocation);
		form('loginForm') {
			j_username = "harrison"
			j_password = "harrison"
			click "OK"
		}
	}	
	
	void testEditUsuarioOK() {
		get(this.defaultLocation);
		form('loginForm') {
			j_username = "harrison"
			j_password = "harrison"
			click "OK"
		}
	}
}

