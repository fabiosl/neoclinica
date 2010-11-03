package core

import java.text.DateFormat;

/**
 * Classe de dominio que mantem informacoes sobre as transacoes de estoque da clinica.
 */
class TransacaoEstoque {
	Lente lente
	Date dataRealizacao
	TransacaoKind tipoTransacao
	String usuario
	Fornecedor fornecedor
	Integer quantidade
	
	public TransacaoEstoque() {
	}
	
	public TransacaoEstoque(Lente lente, Date data, TransacaoKind tipo, String usuario, Integer quantidade, Fornecedor fornecedor) {
		this.lente = lente;
		this.dataRealizacao = data;
		this.tipoTransacao = tipo;
		this.usuario = usuario;
		this.fornecedor = fornecedor;
		this.quantidade = quantidade;
	}
	
	static constraints = {
		lente(nullable : true)
		dataRealizacao(nullable : true)
		tipoTransacao(nullable : true)
		usuario(nullable : true)
		fornecedor(nullable : true)
		quantidade(nullable : true)
	}
	
	public String toString(){
		return "Transação do tipo " + tipoTransacao + ". Data Realizacao " + dataRealizacao.toString() + ". Operador: " + usuario + ". Quantidade de itens mexidos: " + quantidade;
	}
}