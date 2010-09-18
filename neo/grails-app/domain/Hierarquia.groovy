



/**
 * Authority domain class.
 */
class Hierarquia {

	static hasMany = [people: Usuario]

	/** description */
	String description
	/** ROLE String */
	String authority

	static constraints = {
		authority(blank: false, unique: true)
		description()
	}
}
