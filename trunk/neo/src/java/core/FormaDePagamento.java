package core;

public enum FormaDePagamento {
	DINHEIRO("Dinheiro"), CARTAO("Cartao"), CHEQUE("Cheque");

	private String descricao;

	private FormaDePagamento(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public String toString() {
		return getDescricao();
	}

	public static FormaDePagamento getByDescricao(String descricao) {
		for (FormaDePagamento forma : values()) {
			if (forma.getDescricao().equals(descricao)) {
				return forma;
			}
		}
		return null;
	}
}
