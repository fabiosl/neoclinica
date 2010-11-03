package core;

import java.util.HashSet;

/**
 * Classe de dominio pertencente ao "core" do sistema. Mantem as informacoes especificadas no modelo
 * de dados do projeto para modelar um pagamento da clinica.
 */
class Pagamento {
	FormaDePagamento formaDePagamento;
	String cartao;
	
	/**
	 * Relacao 1:N para as prestacoes (1 prestacao equivale a pagamento a vista)
	 */
	static hasMany = [prestacoes : Parcela]
	
	/**
	 * Construtor vazio, requerido pelo Hibernate.
	 */
	public Pagamento() {
	}
	
	public Pagamento(int quantidadeDeParcelas, FormaDePagamento formaDePagamento, String cartao) {
		if(quantidadeDeParcelas < 1){
			quantidadeDeParcelas = 1;
		}
		for (int i = 0; i < quantidadeDeParcelas; i++) {
			addToPrestacoes(new Parcela(i))
		}
		this.formaDePagamento = formaDePagamento;
		this.cartao = cartao;
	}
	
	
	/**
	 * Define a ordenacao das prestacoes pela posicao
	 */
	static mapping = {
		prestacoes sort : "posicao"
	}
	
	/**
	 * Restricoes de integridade
	 */
	static constraints = {
		cartao(nullable : true)
		formaDePagamento(nullable : false, validator: {val, obj ->
			if ((obj?.getCartao() == null || obj?.getCartao().length() == 0) && val == FormaDePagamento.CARTAO) {
				return 'cartaoNaoDefinido'
			}
		})
	}
	
	public String getCartao() {
		return cartao;
	}
	
	/**
	 * O pagamento eh paga a vista se possuir apenas uma "prestacao"
	 * @return um booleano, respondendo se o pagamento eh a vista
	 */
	public boolean pagoAVista() {
		return prestacoes.size() == 1;
	}
	
	/**
	 * Um pagamento ja foi finalizado se todas as parcelas foram pagas.
	 * @return um booleano, respondendo se o pagamento foi finalizado
	 */
	public boolean jaFinalizado() {
		for (Parcela p : prestacoes) {
			if (!p.isPaga()) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Retorna um String representando a forma de pagamento.
	 * @return um String representando a forma de pagamento.
	 */
	public String formaDePagamento() {
		def representacao = "";
		if (pagoAVista()) {
			representacao += "À vista";
		} else {
			representacao += "À prazo (" + (prestacoes.size()) + "x)";
		}
		representacao += " / " + formaDePagamento.getDescricao();
		if (formaDePagamento == FormaDePagamento.CARTAO) {
			representacao += " (" + getCartao() + ")"
		}
		return representacao
	}
	
	/**
	 * Retorna um String representando o pagamento.
	 * @return um String representando o pagamento.
	 */
	public String toString() {
		def representacao = formaDePagamento();
		if (jaFinalizado()) {
			representacao += " - Finalizado"
		}
		return representacao;
	}
}
