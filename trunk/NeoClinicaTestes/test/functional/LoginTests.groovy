
class LoginTests extends functionaltestplugin.FunctionalTestCase {
	private String defaultLocation =  "http://localhost:9000/NEOSoftGrails/login/auth";
	void testAnonymousAccess() {
			get(this.defaultLocation);
			assertContentContains("Digite login e senha")
			
			//			checkHomePage()
    }
}
