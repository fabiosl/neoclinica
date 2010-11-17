package controllers

import java.text.SimpleDateFormat;

/**
 * Controladora de relatorios. Controla as requisicoes para os relatorios de estoque e financeiros.
 *
 */
class RelatoriosController {
	private static SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
	
	def index = {
	}
	
	def relatorio = {
	}
	
	def relatorioFinancaData = {
	
		def convenioId = params["convenioId"]
		if(convenioId.equals('null'))
			convenioId = null;
		def dataInicial = params["dateStart"]
		def dataFinal = params["dateEnd"]
		if (dataInicial == null || dataFinal == null ) {
			flash.message = "Preencha todos os campos!";
			redirect(controller : "estoque", action : "relatorioData");
		} else if (dataInicial.after(dataFinal)) {
			flash.message = "Data inicial posterior a data final!";
			redirect(controller : "estoque", action : "relatorioData");
		} else {
			redirect(url : g.createLinkTo(dir : "/jasper/?_format=PDF&_file=financas&convenioId=" + convenioId +"&dateStart=" + formato.format(dataInicial) + "&dateEnd=" + formato.format(dataFinal)))
		}
	}
		
	
	def relatorioDeTransacoesPorData = {
		def dataInicial = params["dateStart"]
		def dataFinal = params["dateEnd"]
		if (dataInicial == null || dataFinal == null ) {
			flash.message = "Preencha todos os campos!";
			redirect(controller : "estoque", action : "relatorioData");
		} else if (dataInicial.after(dataFinal)) {
			flash.message = "Data inicial posterior a data final!";
			redirect(controller : "estoque", action : "relatorioData");
		} else {
			redirect(url : g.createLinkTo(dir : "/jasper/?_format=PDF&_file=transacoesEstoque&dateStart=" + formato.format(dataInicial) + "&dateEnd=" + formato.format(dataFinal)))
		}
	}
}
