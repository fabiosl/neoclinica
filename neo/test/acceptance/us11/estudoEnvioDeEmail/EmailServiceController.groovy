import org.apache.commons.validator.EmailValidator;

import clinica.Paciente;

class EmailServiceController {
	def enviarEmail(destinatario, assunto, corpo) {
		sendMail {
			to destinatario
			from "EMAIL_DE_DESTINO"
			subject assunto
			body corpo
		}
	}
	
	def enviarEmailHtml(destinatario, assunto, corpo) {
		sendMail {
			to destinatario
			from "EMAIL_DE_DESTINO"
			subject assunto
			html corpo
		}
	}
	
	def enviarEmailClinica(assunto, corpo) {
		enviarEmail("EMAIL_DE_DESTINO", assunto, corpo);
	}
	
	def index = {
		redirect(action: "email", params: params)
	}
	
	def email = {
		return [pacientes : Paciente.findAllByEmailLike("%@%.%")]
	}
	
	def doSend = {
		try {
			sendMail {
				to params.destinatario
				from "EMAIL_DE_DESTINO"
				subject params.assunto
				html params.corpo
			}
			return [sucesso : true]
		} catch (Exception e) {
			return [sucesso : false]
		}
	}
}