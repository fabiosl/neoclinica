package acesso
/**
 * Classe gerada no plugin Acegi
 */
class Hierarquia {
	static hasMany = [people: Usuario]
	
	String description
	String authority
	
	static constraints = {
		authority(blank: false, unique: true)
		description(nullable:true)
	}
}
