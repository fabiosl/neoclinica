package controllers

/**
 * Controladora de logout, gerada pelo plugin Acegi
 */
class LogoutController {
	/**
	 * Acao de logout do sistema, controlada pelo plugin Acegi
	 */
	def index = {
		// colocar aqui codigo extra se necessario
		redirect(uri: '/j_spring_security_logout') // logout do acegi
	}
}
