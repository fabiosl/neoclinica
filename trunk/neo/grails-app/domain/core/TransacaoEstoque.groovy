package core

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

class TransacaoEstoque {
	
	Date dataRealizacao
	TransacaoKind tipoTransacao
	float valor
	
	public String toString(){
		DecimalFormat formato = new DecimalFormat("0.00");
		return "Transacao do tipo " + tipoTransacao + ". Data Realizacao " + dataRealizacao.toString() + ". Valor (em reais): " + formato.format(valor);
	}
}
