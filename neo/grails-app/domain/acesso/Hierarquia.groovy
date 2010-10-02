package acesso

/**
 * Classe gerada no plugin Acegi. Modela um papel do sistema. O mapeamento de autorizacao de paginas
 * a papeis pode ser encontrado em grails-app/conf/SecurityConfig.groovy.
 * 
 * @see SecurityConfig.groovy
 */
class Hierarquia {
	/**
	 * Descricao do papel
	 */
	String description
	
	/**
	 * O nome do papel
	 */
	String authority
	
	/**
	 * Relacionamento muitos para muitos. Um papel pode ter varias pessoas envolvidas.
	 */
	static hasMany = [people : Usuario]
	
	/**
	 * Restricoes de integridade
	 */
	static constraints = {
		authority(blank: false, unique: true)
		description(nullable:true)
	}
}
