class CRUDUsuarioFunctionalTests extends functionaltestplugin.FunctionalTestCase {
	private String defaultLocation =  "http://localhost:9000/NEOSoftGrails/login/auth";
	
	private String username = "teste";
	
	void testAddUsuarioOK() {
		get(this.defaultLocation);
		form('loginForm') {
			j_username = "harrison"
			j_password = "harrison"
			click "OK"
		}
		
		click "linkopcoes"
		click "linkusuario"
		click "Novo Usuario"
		form('addUsuarioForm') {
			username = this.username;
			userRealName = "Teste";
			passwd = this.username; 
			enabled = true;
			email = this.username + "@" + this.username + "." + this.username;
			ROLE_MANUTENCAO = true;
			click "create"
		}
		assertContentContains "Ver Usuario"
		
	}	
	
	void testLogarUsuarioCriado() {
		//Testa adicionar usuario logando sem privilegio para isso.
		get(this.defaultLocation);
		form('loginForm') {
			j_username = this.username
			j_password = this.username
			click "OK"
		}
		
		assertContentContains "Teste, bem vindo ao SI Neo"
	}

	void testRemoveCriado() {
		get(this.defaultLocation);
		form('loginForm') {
			j_username = "harrison"
			j_password = "harrison"
			click "OK"
		}
		click "linkopcoes"
		click "linkusuario"
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

