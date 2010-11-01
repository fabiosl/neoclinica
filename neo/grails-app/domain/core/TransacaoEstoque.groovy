package core

import java.text.DateFormat;
import java.text.DecimalFormat;

class TransacaoEstoque {
	
	Date dataRealizacao
	TransacaoKind tipoTransacao
	String usuario
	int quantidade
	public String toString(){
		return "Transacao do tipo " + tipoTransacao + ". Data Realizacao " + DateFormat.format(dataRealizacao) + ". Operador: " + usuario + ". Quantidade de itens mexidos: " + quantidade;
	}
}
