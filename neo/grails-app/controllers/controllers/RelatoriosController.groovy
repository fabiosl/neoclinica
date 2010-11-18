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
	
	def relatorioFinancaData = {
		
	}
	
	def doRelatorioFinanceiroData = {
		def tipoProcedimento = params["tipoProcedimento"];
		def dataInicial = params["dateStart"];
		def dataFinal = params["dateEnd"];
		
		if (dataInicial == null || dataFinal == null ) {
			flash.message = "Preencha todos os campos!";
			redirect(action : "relatorioFinancaData");
		} else if (dataInicial.after(dataFinal)) {
			flash.message = "Data inicial posterior a data final!";
			redirect(action : "relatorioFinancaData");
		} else {
			if (tipoProcedimento.equals("Vendas de Lente")) {
				redirect(url : g.createLinkTo(dir : "/jasper/?_format=PDF&_file=relatorioFinanceiroVendas&dateStart=" + formato.format(dataInicial) + "&dateEnd=" + formato.format(dataFinal)));
			} else if (tipoProcedimento.equals("Procedimento Medico")) {
				redirect(url : g.createLinkTo(dir : "/jasper/?_format=PDF&_file=relatorioFinanceiroProcedimentoMedico&dateStart=" + formato.format(dataInicial) + "&dateEnd=" + formato.format(dataFinal)));
			}
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
