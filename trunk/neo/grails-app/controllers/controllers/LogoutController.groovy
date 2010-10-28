package controllers

/**
 * Controladora de logout, gerada pelo plugin Acegi
 */
class LogoutController {
	/**
	 * Acao de logout do sistema, controlada pelo plugin Acegi
	 */
	def index = {
		redirect(uri: '/j_spring_security_logout') // logout do acegi
	}
}
