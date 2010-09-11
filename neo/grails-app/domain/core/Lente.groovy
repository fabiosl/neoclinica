package core

class Lente {
	String tipo;
	int quantidade;
	float valor;
	
	static constraints = {
		tipo(nullable : false, blank : false, maxSize : 100, minSize : 3)
		quantidade(nullable : false, min : 0)
		valor(nullable : false, min : 0F)
	}
	
	public String toString() {
		return getTipo();
	}
}
