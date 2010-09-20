package acesso
/**
 * Classe gerada no plugin Acegi
 */
class Usuario {
	static transients = ['pass']
	static hasMany = [authorities: Hierarquia]
	static belongsTo = Hierarquia
	
	String username
	String userRealName
	String passwd
	boolean enabled
	
	String email
	boolean emailShow
	
	String description = ''
	String pass = '[secret]'
	
	static constraints = {
		username(blank: false, unique: true)
		userRealName(blank: false)
		passwd(blank: false)
	}
}
