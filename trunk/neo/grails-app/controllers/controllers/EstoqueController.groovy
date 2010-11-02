package controllers


import java.util.Calendar;

import java.util.Date;

import core.DateParser;
import core.Lente 
import core.TransacaoEstoque 

/**
 * Controladora de estoque, para acoes gerais sobre o estoque da clinica (como geracao de relatorios).
 */
class EstoqueController {
	
	def index = {
	}
	
	def relatorio = {
	}
	
	def relatorioData = {

	}
	
	def relatorioHoje = {
		
		def lentes = Lente.findAll();
		
		System.out.println(lentes);
		
		def Date agora = new Date();
		def outra = DateParser.getStartingDate(agora);
		def transacoes = TransacaoEstoque.findAllByDataRealizacaoBetween(outra, agora);
		
		System.out.println("Invevalo entre " + outra.toString() + " e " + agora.toString());
		System.out.println("Minhas transacoes " + transacoes);
		//gerar pdf com a lista das lentes
	}
	
	def escolher = {
		def dataRelatorio = params.dataRelatorio
		System.out.println("peguei a data " + dataRelatorio);
		def dataInicio = DateParser.getStartingDate(dataRelatorio);
		Calendar c = Calendar.getInstance();
		c.setTime(dataInicio);
		c.add(Calendar.HOUR, 24);
		def dataFim = c.getTime();
		System.out.println("Relatorio entre " + dataInicio + " e " + dataFim);
		def transacoes = TransacaoEstoque.findAllByDataRealizacaoBetween(dataInicio, dataFim);
	}
}
