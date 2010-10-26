package controllers

import core.Lente 

/**
 * Controladora de lentes. Controla as atividades de CRUD sob
 * as lentes cadastradas no sistema. Classe gerada pelo framework Grails.
 *
 * @see core.Lente
 */
class LenteController {
	def index = {

	}
	
	def scaffold = Lente;
	
	def venda = {
		def lentes = Lente.findAll()
		def lista = []
		for(Lente l: lentes){
			lista.add(l.getTipo())
		}
		return [validos : lista]
	}
	
	def fazVenda = {}
}
