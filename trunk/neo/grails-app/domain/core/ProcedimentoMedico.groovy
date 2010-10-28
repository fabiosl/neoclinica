package core

class ProcedimentoMedico extends Procedimento {
	TipoProcedimentoMedico tipo
	Date data
	String informacoes
	
	/**
	 * Relacionamentos 1:1
	 */
	static belongsTo = [medico : Medico]
	
	static constraints = {
		tipo(nullable : false);
		data(nullable : false);
		informacoes(nullable : true, maxSize : 2000)
	}
}
