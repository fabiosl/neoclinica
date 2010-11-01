package controllers

import core.Compra;
import core.Paciente;
import core.Pagamento;
import core.FormaDePagamento;
import core.Parcela 

/**
 * Controladora de compras. Controla as atividades de CRUD sob
 * as compras realizadas ba clinica. Classe gerada pelo framework Grails.
 *
 * @see core.Compra
 */
class CompraController {
	def scaffold = Compra
	
	def list = {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
		if (params.idPaciente) {
			def paciente = Paciente.get(params.idPaciente)
			def consulta = Compra.createCriteria().list(params) {
				eq("paciente", paciente)
			}
			def cont = consulta != null ? consulta.count() : 0
			return [compraInstanceList : consulta, compraInstanceTotal: cont, paciente : paciente]
		} else {
			return [compraInstanceList : Compra.list(params), compraInstanceTotal: Compra.count()]
		}
	}
	
	def create = {
		def compraInstance = new Compra()
		compraInstance.properties = params
		def paciente = null
		if (params.idPaciente != null) {
			paciente = Paciente.get(params.idPaciente)
		}
		return [compraInstance : compraInstance, pacientePreDefinido : paciente]
	}
	
	def save = {
		def compraInstance = new Compra(params)
		
		def formaDePagamento = FormaDePagamento.getByDescricao(params.formaDePagamento);
		def cartao = params.cartao;
		def parcelas = Integer.valueOf(params.quantidadeDeParcelas)
		
		compraInstance.pagamento = new Pagamento(parcelas, formaDePagamento, cartao);
		if (compraInstance.pagamento.save() && compraInstance.save(flush: true)) {
			flash.message = "${message(code: 'default.created.message', args: [message(code: 'compra.label', default: 'Compra'), compraInstance.id])}"
			redirect(action: "show", id: compraInstance.id)
		} else {
			render(view: "create", model: [compraInstance : compraInstance])
		}
	}
	
	def show = {
		def compraInstance = Compra.get(params.id)
		if (!compraInstance) {
			flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'compra.label', default: 'Compra'), params.id])}"
			redirect(action : "list")
		} else {
			[compraInstance: compraInstance]
		}
	}
	
	def delete = {
		def compraInstance = Compra.get(params.id)
		if (compraInstance) {
			try {
				compraInstance.delete(flush: true)
				compraInstance.pagamento.delete(flush: true)
				flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'compra.label', default: 'Compra'), params.id])}"
				redirect(action: "list", params : [idPaciente : compraInstance.paciente.id])
			}
			catch (org.springframework.dao.DataIntegrityViolationException e) {
				flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'compra.label', default: 'Compra'), params.id])}"
				redirect(action: "show", id: params.id)
			}
		}
		else {
			flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'compra.label', default: 'Compra'), params.id])}"
			redirect(action: "list")
		}
	}
	
	def edit = {
		def compraInstance = Compra.get(params.id)
		if (!compraInstance) {
			flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'compra.label', default: 'Compra'), params.id])}"
			redirect(action: "list")
		}
		else {
			return [compraInstance : compraInstance]
		}
	}
	
	def update = {
		def compraInstance = Compra.get(params.id)
		if (compraInstance) {
			if (params.version) {
				def version = params.version.toLong()
				if (compraInstance.version > version) {
					compraInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'compra.label', default: 'Compra')] as Object[], "Another user has updated this Compra while you were editing")
					render(view: "edit", model: [compraInstance: compraInstance])
					return
				}
			}
			
			compraInstance.properties = params
			
			def parcelasTemErros = false
			for (Parcela p : compraInstance.pagamento.prestacoes) {
				def paramPaga = params["parcela_" + p.id + "_paga"];
				def paramData = params["parcela_" + p.id + "_data"];
				def paramValor = params["parcela_" + p.id + "_valor"];
				
				if (paramPaga != null) {
					paramPaga = true
					paramValor = paramValor != null ? paramValor.replace(",", ".") : "";
				} else {
					paramPaga = false
					paramData = null
					paramValor = 0
				}
				
				def parametros = [paga : paramPaga, dataDePagamento : paramData, valor : paramValor]
				bindData(p, parametros)
				if (!p.validate()) {
					parcelasTemErros = true
				}
			}
			
			if (!parcelasTemErros && !compraInstance.hasErrors() && compraInstance.save(flush: true)) {
				flash.message = "${message(code: 'default.updated.message', args: [message(code: 'compra.label', default: 'Compra'), compraInstance.id])}"
				redirect(action: "show", id: compraInstance.id)
			} else {
				render(view: "edit", model: [compraInstance: compraInstance])
			}
		}
		else {
			flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'compra.label', default: 'Compra'), params.id])}"
			redirect(action: "list")
		}
	}
	
	//	def save = {
	//		def transacaoRealizada = new TransacaoEstoque();
	//		transacaoRealizada.dataRealizacao = params.dataPedido;
	//		transacaoRealizada.tipoTransacao = TransacaoKind.VENDA;
	//		transacaoRealizada.usuario = pegar login do usuario logado;
	//		transacaoRealizada.quantidade = params.quantidade;
	//		transacaoRealizada.save();
	//	}
}
