package core

import java.util.Date;

class Paciente extends Pessoa {
	String profissao
	
	static constraints = {
		email(email : true, nullable : false, blank : true, maxSize : 50)
	}
}
