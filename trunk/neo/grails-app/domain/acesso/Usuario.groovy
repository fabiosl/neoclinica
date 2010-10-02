package acesso

/**
 * Classe gerada no plugin Acegi. Modela um usuario do sistema, entidade cujos dados sao mantidos no banco
 * de dados. Um usuario possui varias autoridades (papeis) no sistema, modeladas pela entidade Hierarquia.
 */
class Usuario {
	/**
	 * Login
	 */
	String username
	
	/**
	 * Nome
	 */
	String userRealName
	
	/**
	 * Senha (sem criptografia)
	 */
	String passwd
	
	/**
	 * Diz se o usuario esta habilitado
	 */
	boolean enabled
	
	/**
	 * Email do usuario
	 */
	String email
	
	/**
	 * Diz se o email deve ser publicado
	 */
	boolean emailShow
	
	/**
	 * Descricao do usuario
	 */
	String description = ''
	
	/**
	 * Versao do password usada nas requisicoes, criptografada
	 */
	String pass = '[secret]'
	
	static transients = ['pass']
	
	/**
	 * Relacionamento muitos-para-muitos. Um usuario pode ter varios papeis.
	 */
	static hasMany = [authorities : Hierarquia]
	
	/**
	 * Define dependencia, para que um papel nao possa ser deletado enquanto houver usuarios.
	 */
	static belongsTo = Hierarquia
	
	/**
	 * Restricoes de integridade
	 */
	static constraints = {
		username(blank: false, unique: true)
		userRealName(blank: false)
		passwd(blank: false)
	}
}
