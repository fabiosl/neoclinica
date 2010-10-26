package core

class ProcedimentoMedico extends Procedimento {

	Date data
	String nome
	String informacoes
	
	static constraints = {
		data(nullable:false);
		nome(nullable:false, minSize:4);
	}
}
