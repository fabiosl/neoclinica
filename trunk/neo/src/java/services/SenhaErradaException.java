package services;

public class SenhaErradaException extends RuntimeException {
	private static final long serialVersionUID = -2975857156406958439L;

	public SenhaErradaException(String mensagem) {
		super(mensagem);
	}
}
