package core;

import java.util.Date;

/**
 * Classe de dominio pertencente ao "core" do sistema. Mantem as informacoes especificadas no modelo
 * de dados do projeto para representar as parcelas. Uma parcela no SI Neo eh vista como uma unidade de
 * pagamento, sendo um pagamento a vista, por exemplo, um pagamento com uma unica parcela.
 */
class Parcela {
	Date dataDePagamento;
	Float valor = 0.0;
	Integer posicao;
	boolean paga = false;
	
	/**
	 * Construtor vazio requerido pelo Hibernate.
	 */
	public Parcela() {
	}
	
	public Parcela(int posicao) {
		this.posicao = posicao;
	}
	
	/**
	 * Restricao de dependencia entre parcela e pagamento.
	 */
	static belongsTo = [pagamento : Pagamento]
	
	/**
	 * Restricoes de integridade.
	 */
	static constraints = {
		dataDePagamento(nullable : true, validator: {val, obj ->
			if (obj?.paga == null && dataDePagamento == null) {
				return 'dataDePagamentoNaoDefinida'
			}
		})
		posicao(nullable : true, min : 0)
		valor(nullable : true, min : 0F)
	}
	
	/**
	 * Diz se a parcela ja foi paga.
	 * @return um booleano respondendo se a parcela ja foi paga.
	 */
	public boolean isPaga() {
		return paga;
	}
	
	/**
	 * Retorna a data de pagamento da parcela, caso ela tenha sido paga.
	 * @return a data de pagamento da parcela, ou null se nao tiver sido paga.
	 */
	public Date getDataDePagamento() {
		return paga ? dataDePagamento : null;
	}
}
