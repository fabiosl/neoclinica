package core

import java.text.SimpleDateFormat;

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
	
	public String toString(){
		def formato = new SimpleDateFormat("dd/MM/yyyy");
		def separator = System.getProperty("line.separator");
		StringBuilder output = new StringBuilder()
		output.append(tipo.toString() + " do paciente: " + paciente.toString() +"." +  separator)
		output.append("Marcado com o Dr(a). " + medico.toString() +"."+ separator)
		output.append("Data: " + formato.format(data) + "." + separator);
		return output.toString()
	}
}
