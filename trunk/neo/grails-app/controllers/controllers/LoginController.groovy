package controllers

import org.springframework.security.AuthenticationTrustResolverImpl
import org.springframework.security.DisabledException
import org.springframework.security.context.SecurityContextHolder as SCH
import org.springframework.security.ui.AbstractProcessingFilter
import org.springframework.security.ui.webapp.AuthenticationProcessingFilter

/**
 * Controladora de login, que atende as requisicoes HTTP dos usuarios e responde de acordo com a acao.
 */
class LoginController {
	/**
	 * Servicos do plugin Acegi (fornecem, entre outras coisas, criptografia de senhas)
	 */
	def authenticateService
	def openIDConsumer
	def openIDAuthenticationProcessingFilter
	
	private final authenticationTrustResolver = new AuthenticationTrustResolverImpl()
	
	/**
	 * Acao inicial de qualquer controladora (acessada via pagina /login)
	 */
	def index = {
		redirect action: auth, params: params
	}
	
	/**
	 * Acao que redireciona para a pagina de autenticacao, quando nao se tem autorizacao
	 */
	def redirectMainPage = {
		response.sendRedirect("/NEOSoftGrails/login/auth")
	}
	
	/**
	 * Acao principal de autenticacao
	 */
	def auth = {
		nocache response
		
		if (isLoggedIn()) {
			redirect uri: '/main.gsp'
			return
		}
		
		String view
		String postUrl
		def config = authenticateService.securityConfig.security
		if (config.useOpenId) {
			view = 'openIdAuth'
			postUrl = "${request.contextPath}/login/openIdAuthenticate"
		}
		else if (config.useFacebook) {
			view = 'facebookAuth'
			postUrl = "${request.contextPath}${config.facebook.filterProcessesUrl}"
		}
		else {
			view = 'auth'
			postUrl = "${request.contextPath}${config.filterProcessesUrl}"
		}
		
		render view: view, model: [postUrl: postUrl]
	}
	
	
	def openIdAuthenticate = {
		String openID = params['j_username']
		try {
			String returnToURL = RedirectUtils.buildRedirectUrl(
			request, response, openIDAuthenticationProcessingFilter.filterProcessesUrl)
			String redirectUrl = openIDConsumer.beginConsumption(request, openID, returnToURL)
			redirect url: redirectUrl
		}
		catch (Exception e) {
			log.error "Consumer error: $e.message", e
			redirect url: openIDAuthenticationProcessingFilter.authenticationFailureUrl
		}
	}
	
	/**
	 * Metodos para autenticacao Ajax (gerados automaticamente)
	 */
	def authAjax = {
		nocache(response)
		//this is example:
		render """
		<script type='text/javascript'>
		(function() {
			loginForm();
		})();
		</script>
		"""
	}
	
	/**
	 * Metodos para autenticacao Ajax (gerados automaticamente)
	 */
	def ajaxSuccess = {
		nocache(response)
		render '{success: true}'
	}
	
	/**
	 * Acao de acesso negado, requisitada de acordo com o controle do plugin
	 */
	def denied = {
		if (isLoggedIn() && authenticationTrustResolver.isRememberMe(SCH.context?.authentication)) {
			// have cookie but the page is guarded with IS_AUTHENTICATED_FULLY
			redirect action: full, params: params
		}
	}
	
	def full = {
		render view: 'auth', params: params,
		model: [hasCookie: authenticationTrustResolver.isRememberMe(SCH.context?.authentication)]
	}
	
	// Denial page (data|view|json) for Ajax access.
	def deniedAjax = {
		//this is example:
		render "{error: 'access denied'}"
	}
	
	/**
	 * Acao de falha de autenticacao, redireciona para pagina de erro
	 */
	def authfail = {
		def username = session[AuthenticationProcessingFilter.SPRING_SECURITY_LAST_USERNAME_KEY]
		def msg = ''
		def exception = session[AbstractProcessingFilter.SPRING_SECURITY_LAST_EXCEPTION_KEY]
		if (exception) {
			if (exception instanceof DisabledException) {
				msg = "[$username] esta desabilitado."
			}
			else {
				msg = "Nome ou senha invalidos."
			}
		}
		
		if (isAjax()) {
			render "{error: '${msg}'}"
		} else {
			flash.message = msg
			redirect action: auth, params: params
		}
	}
	
	/**
	 * Checa se esta logado
	 */
	private boolean isLoggedIn() {
		return authenticateService.isLoggedIn()
	}
	
	/**
	 * Checa se a requisicao eh ajax
	 */
	private boolean isAjax() {
		return authenticateService.isAjax(request)
	}
	
	/** controle de cache */
	private void nocache(response) {
		response.setHeader('Cache-Control', 'no-cache') // HTTP 1.1
		response.addDateHeader('Expires', 0)
		response.setDateHeader('max-age', 0)
		response.setIntHeader ('Expires', -1) //prevents caching at the proxy server
		response.addHeader('cache-Control', 'private') //IE5.x only
	}
}
