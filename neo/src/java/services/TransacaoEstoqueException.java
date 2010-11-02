package services;

public class TransacaoEstoqueException extends RuntimeException {
	private static final long serialVersionUID = -6132049757225139121L;

	public TransacaoEstoqueException(String mensagem) {
		super(mensagem);
	}
}
