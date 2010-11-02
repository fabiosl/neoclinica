package services;

public class DadosInvalidosException extends RuntimeException {
	private static final long serialVersionUID = -5107892317106717435L;

	public DadosInvalidosException(String mensagem) {
		super(mensagem);
	}
}
