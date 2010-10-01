package core

class ConvenioController {
	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	
	def index = {
		redirect(action: "list", params: params)
	}
	
	def list = {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
		[convenioInstanceList: Convenio.list(params), convenioInstanceTotal: Convenio.count()]
	}
	
	def create = {
		def convenioInstance = new Convenio()
		convenioInstance.properties = params
		return [convenioInstance: convenioInstance]
	}
	
	def save = {
		def convenioInstance = new Convenio(params)
		if (convenioInstance.save(flush: true)) {
			flash.message = "${message(code: 'default.created.message', args: [message(code: 'convenio.label', default: 'Convenio'), convenioInstance.id])}"
			redirect(action: "show", id: convenioInstance.id)
		}
		else {
			render(view: "create", model: [convenioInstance: convenioInstance])
		}
	}
	
	def show = {
		def convenioInstance = Convenio.get(params.id)
		if (!convenioInstance) {
			flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'convenio.label', default: 'Convenio'), params.id])}"
			redirect(action: "list")
		}
		else {
			[convenioInstance: convenioInstance]
		}
	}
	
	def edit = {
		def convenioInstance = Convenio.get(params.id)
		if (!convenioInstance) {
			flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'convenio.label', default: 'Convenio'), params.id])}"
			redirect(action: "list")
		}
		else {
			return [convenioInstance: convenioInstance]
		}
	}
	
	def update = {
		def convenioInstance = Convenio.get(params.id)
		if (convenioInstance) {
			if (params.version) {
				def version = params.version.toLong()
				if (convenioInstance.version > version) {
					
					convenioInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'convenio.label', default: 'Convenio')] as Object[], "Another user has updated this Convenio while you were editing")
					render(view: "edit", model: [convenioInstance: convenioInstance])
					return
				}
			}
			convenioInstance.properties = params
			if (!convenioInstance.hasErrors() && convenioInstance.save(flush: true)) {
				flash.message = "${message(code: 'default.updated.message', args: [message(code: 'convenio.label', default: 'Convenio'), convenioInstance.id])}"
				redirect(action: "show", id: convenioInstance.id)
			}
			else {
				render(view: "edit", model: [convenioInstance: convenioInstance])
			}
		}
		else {
			flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'convenio.label', default: 'Convenio'), params.id])}"
			redirect(action: "list")
		}
	}
	
	def delete = {
		def convenioInstance = Convenio.get(params.id)
		if (convenioInstance) {
			try {
				convenioInstance.delete(flush: true)
				flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'convenio.label', default: 'Convenio'), params.id])}"
				redirect(action: "list")
			}
			catch (org.springframework.dao.DataIntegrityViolationException e) {
				flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'convenio.label', default: 'Convenio'), params.id])}"
				redirect(action: "show", id: params.id)
			}
		}
		else {
			flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'convenio.label', default: 'Convenio'), params.id])}"
			redirect(action: "list")
		}
	}
}
