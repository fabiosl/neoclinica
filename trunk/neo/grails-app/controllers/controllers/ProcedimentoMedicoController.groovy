package controllers

import core.FormaDePagamento 
import core.Paciente 
import core.Pagamento 
import core.Parcela 
import core.ProcedimentoMedico 

/**
 * Controladora de procedimentos medicos. Controla as atividades de CRUD sob
 * os procedimentos medicos da clinica. Classe gerada pelo framework Grails.
 *
 * @see core.ProcedimentoMedico
 */
class ProcedimentoMedicoController {
	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	
	def index = {
	}
	
	def list = {
		if (params.idPaciente) {
			def paciente = Paciente.get(params.idPaciente)
			def consulta = ProcedimentoMedico.createCriteria().list(params) {
				eq("paciente", paciente)
			}
			def cont = consulta != null ? consulta.size() : 0
			return [procedimentoMedicoInstanceList: consulta, procedimentoMedicoInstanceTotal: cont, paciente : paciente]
		} else {
			return [procedimentoMedicoInstanceList : ProcedimentoMedico.list(params), procedimentoMedicoInstanceTotal: ProcedimentoMedico.count()]
		}
	}
	
	def create = {
		def procedimentoMedicoInstance = new ProcedimentoMedico()
		procedimentoMedicoInstance.properties = params
		def paciente = null
		if (params.idPaciente != null) {
			paciente = Paciente.get(params.idPaciente)
		}
		return [procedimentoMedicoInstance : procedimentoMedicoInstance, pacientePreDefinido : paciente]
	}
	
	def save = {
		def procedimentoMedicoInstance = new ProcedimentoMedico(params)
		
		def formaDePagamento = FormaDePagamento.getByDescricao(params.formaDePagamento);
		def cartao = params.cartao;
		def parcelas = Integer.valueOf(params.quantidadeDeParcelas)
		
		procedimentoMedicoInstance.pagamento = new Pagamento(parcelas, formaDePagamento, cartao);
		if (procedimentoMedicoInstance.pagamento.save() && procedimentoMedicoInstance.save(flush: true)) {
			flash.message = "${message(code: 'default.created.message', args: [message(code: 'procedimentoMedico.label', default: 'ProcedimentoMedico'), procedimentoMedicoInstance.id])}"
			redirect(action: "show", id: procedimentoMedicoInstance.id)
		} else {
			render(view: "create", model: [procedimentoMedicoInstance: procedimentoMedicoInstance])
		}
	}
	
	def show = {
		def procedimentoMedicoInstance = ProcedimentoMedico.get(params.id)
		if (!procedimentoMedicoInstance) {
			flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'procedimentoMedico.label', default: 'ProcedimentoMedico'), params.id])}"
			redirect(action: "list")
		} else {
			[procedimentoMedicoInstance: procedimentoMedicoInstance]
		}
	}
	
	def edit = {
		def procedimentoMedicoInstance = ProcedimentoMedico.get(params.id)
		if (!procedimentoMedicoInstance) {
			flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'procedimentoMedico.label', default: 'ProcedimentoMedico'), params.id])}"
			redirect(action: "list")
		}
		else {
			return [procedimentoMedicoInstance: procedimentoMedicoInstance]
		}
	}
	
	def update = {
		def procedimentoMedicoInstance = ProcedimentoMedico.get(params.id)
		if (procedimentoMedicoInstance) {
			if (params.version) {
				def version = params.version.toLong()
				if (procedimentoMedicoInstance.version > version) {
					procedimentoMedicoInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'procedimentoMedico.label', default: 'ProcedimentoMedico')] as Object[], "Another user has updated this ProcedimentoMedico while you were editing")
					render(view: "edit", model: [procedimentoMedicoInstance: procedimentoMedicoInstance])
					return
				}
			}
			procedimentoMedicoInstance.properties = params
			
			def parcelasTemErros = false
			for (Parcela p : procedimentoMedicoInstance.pagamento.prestacoes) {
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
			
			if (!parcelasTemErros && !procedimentoMedicoInstance.hasErrors() && procedimentoMedicoInstance.save(flush: true)) {
				flash.message = "${message(code: 'default.updated.message', args: [message(code: 'procedimentoMedico.label', default: 'ProcedimentoMedico'), procedimentoMedicoInstance.id])}"
				redirect(action: "show", id: procedimentoMedicoInstance.id)
			} else {
				render(view: "edit", model: [procedimentoMedicoInstance: procedimentoMedicoInstance])
			}
		}
		else {
			flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'procedimentoMedico.label', default: 'ProcedimentoMedico'), params.id])}"
			redirect(action: "list")
		}
	}
	
	def delete = {
		def procedimentoMedicoInstance = ProcedimentoMedico.get(params.id)
		if (procedimentoMedicoInstance) {
			try {
				procedimentoMedicoInstance.delete(flush: true)
				procedimentoMedicoInstance.pagamento.delete(flush: true)
				flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'procedimentoMedico.label', default: 'ProcedimentoMedico'), params.id])}"
				redirect(action: "list", params : [idPaciente : procedimentoMedicoInstance.paciente.id])
			}
			catch (org.springframework.dao.DataIntegrityViolationException e) {
				flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'procedimentoMedico.label', default: 'ProcedimentoMedico'), params.id])}"
				redirect(action: "show", id: params.id)
			}
		}
		else {
			flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'procedimentoMedico.label', default: 'ProcedimentoMedico'), params.id])}"
			redirect(action: "list")
		}
	}
}
