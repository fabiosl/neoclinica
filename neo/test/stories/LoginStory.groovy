String page = "http://localhost:9000/NEOSoftGrails/login/auth";

story "	Login Story", {
	scenario "Tela de login", {
		get (resource: page) {
			assert status == 200
			
		}
	}
}