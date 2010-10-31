package controllers

/**
 * Controladora de estoque, para acoes gerais sobre o estoque da clinica (como geracao de relatorios).
 */
class EstoqueController {
	def index = {}
	
	def relatorio = {}
	
	def relatorioData = {}
	
	def relatorioHoje = {}
	
	def escolher = {
		def data = params.dataRelatorio
		System.out.println("peguei a data " + data.toString());
		
		}
}
