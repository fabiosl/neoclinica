package core

/**
 * Classe abstrata que mantem informacoes em comum a todos os procedimentos
 * da clinica, valor e paciente.
 */
abstract class Procedimento {
	Float valor = 0.0;
	Pagamento pagamento;
	
	/**
	 * Relacionamentos 1:1
	 */
	static belongsTo = [paciente : Paciente]
	
	/**
	 * Restricoes de integridade
	 */
	static constraints = {
		valor(nullable : false, min : 0F);
	}
}
