package core

class FornecedorController {
	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	
	def index = {
		redirect(action: "list", params: params)
	}
	
	def list = {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
		[fornecedorInstanceList: Fornecedor.list(params), fornecedorInstanceTotal: Fornecedor.count()]
	}
	
	def create = {
		def fornecedorInstance = new Fornecedor()
		fornecedorInstance.properties = params
		return [fornecedorInstance: fornecedorInstance]
	}
	
	def save = {
		def fornecedorInstance = new Fornecedor(params)
		if (fornecedorInstance.save(flush: true)) {
			flash.message = "${message(code: 'default.created.message', args: [message(code: 'fornecedor.label', default: 'Fornecedor'), fornecedorInstance.id])}"
			redirect(action: "show", id: fornecedorInstance.id)
		}
		else {
			render(view: "create", model: [fornecedorInstance: fornecedorInstance])
		}
	}
	
	def show = {
		def fornecedorInstance = Fornecedor.get(params.id)
		if (!fornecedorInstance) {
			flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'fornecedor.label', default: 'Fornecedor'), params.id])}"
			redirect(action: "list")
		}
		else {
			[fornecedorInstance: fornecedorInstance]
		}
	}
	
	def edit = {
		def fornecedorInstance = Fornecedor.get(params.id)
		if (!fornecedorInstance) {
			flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'fornecedor.label', default: 'Fornecedor'), params.id])}"
			redirect(action: "list")
		}
		else {
			return [fornecedorInstance: fornecedorInstance]
		}
	}
	
	def update = {
		def fornecedorInstance = Fornecedor.get(params.id)
		if (fornecedorInstance) {
			if (params.version) {
				def version = params.version.toLong()
				if (fornecedorInstance.version > version) {
					
					fornecedorInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'fornecedor.label', default: 'Fornecedor')] as Object[], "Another user has updated this Fornecedor while you were editing")
					render(view: "edit", model: [fornecedorInstance: fornecedorInstance])
					return
				}
			}
			fornecedorInstance.properties = params
			if (!fornecedorInstance.hasErrors() && fornecedorInstance.save(flush: true)) {
				flash.message = "${message(code: 'default.updated.message', args: [message(code: 'fornecedor.label', default: 'Fornecedor'), fornecedorInstance.id])}"
				redirect(action: "show", id: fornecedorInstance.id)
			}
			else {
				render(view: "edit", model: [fornecedorInstance: fornecedorInstance])
			}
		}
		else {
			flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'fornecedor.label', default: 'Fornecedor'), params.id])}"
			redirect(action: "list")
		}
	}
	
	def delete = {
		def fornecedorInstance = Fornecedor.get(params.id)
		if (fornecedorInstance) {
			try {
				fornecedorInstance.delete(flush: true)
				flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'fornecedor.label', default: 'Fornecedor'), params.id])}"
				redirect(action: "list")
			}
			catch (org.springframework.dao.DataIntegrityViolationException e) {
				flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'fornecedor.label', default: 'Fornecedor'), params.id])}"
				redirect(action: "show", id: params.id)
			}
		}
		else {
			flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'fornecedor.label', default: 'Fornecedor'), params.id])}"
			redirect(action: "list")
		}
	}
}
