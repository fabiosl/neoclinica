package core

import java.util.Date;

class Paciente extends Pessoa {
	static constraints = {
		email(email : true, nullable : false, blank : true, maxSize : 50)
	}
}
