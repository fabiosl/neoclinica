package core

class Convenio {
	String nome;
	
	static belongsTo = Paciente;
	
	String toString(){
		return this.nome;
	}
}
