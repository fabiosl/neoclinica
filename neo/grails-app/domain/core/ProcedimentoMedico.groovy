package core

/**
 * Classe que mantem informacoes dos procedimentos medicos da clinica. Um procedimento medico
 * eh realizado por um medico, possui um tipo pre definido e informacoes adicionais, alem das propriedades
 * da classe pai.
 */
class ProcedimentoMedico extends Procedimento {
	TipoProcedimentoMedico tipo
	Date data
	String informacoes
	
	/**
	 * Relacionamentos 1:1
	 */
	static belongsTo = [medico : Medico]
	
	/**
	 * Restricoes de Integridade
	 */
	static constraints = {
		tipo(nullable : false);
		data(nullable : false);
		informacoes(nullable : true, maxSize : 2000)
	}
	
	public String getInformacoes(){
		return informacoes
	}
}
