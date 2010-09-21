package acesso

/**
 * Classe gerada no plugin Acegi. Modela um papel do sistema. O mapeamento de autorizacao de paginas
 * a papeis pode ser encontrado em grails-app/conf/SecurityConfig.groovy.
 * 
 * @see SecurityConfig.groovy
 */
class Hierarquia {
	static hasMany = [people:Usuario]
	
	/**
	 * Descricao do papel
	 */
	String description
	
	/**
	 * O nome do papel
	 */
	String authority
	
	static constraints = {
		authority(blank: false, unique: true)
		description(nullable:true)
	}
}
