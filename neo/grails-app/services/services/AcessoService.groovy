package services

import acesso.Usuario;

/**
 * Servico que encapsula logica de negocio referente a alteracao de senha dos usuarios.
 * Funcionalidade a mais que o Acegi nao prove nativamente.
 */
class AcessoService {
	// TODO definir propriedades do servico (VER LINKS UTEIS NO GRUPO)
	
	def authenticateService /* Acegi */
	
	def alterarSenha(senhaAtual, novaSenha) {
		Usuario usuario = authenticateService.userDomain();
		usuario = Usuario.get(usuario.id);
		
		senhaAtual = authenticateService.encodePassword(senhaAtual)
		if (senhaAtual != usuario.getPasswd()) {
			throw new SenhaErradaException("Senha errada, tente novamente.")
		}
		
		usuario.setPasswd(authenticateService.encodePassword(novaSenha));
		usuario.save();
	}
}
