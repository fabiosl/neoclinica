package controllers

import core.Fornecedor;
import core.Fornecimento;
import core.Lente 

class FornecimentoController {
	def scaffold = Fornecimento;
	
	def index = {
		redirect(action : 'create')
	}
	
	def create = {
		def lentes = Lente.findAll()
		def lista = []
		for(Lente l: lentes){
			lista.add(l.getTipo())
		}
		def fornecedores = Fornecedor.findAll()
		def lista2 = []
		for(Fornecedor f: fornecedores){
			lista2.add(f.getNome())
		}
		return [validos : lista, validos2: lista2]
	}
}
