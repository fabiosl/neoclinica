package controllers
class LogoutController {
	def index = {
		// TODO colocar aqui codigo pra logout
		redirect(uri: '/j_spring_security_logout') // logout do acegi
	}
}
