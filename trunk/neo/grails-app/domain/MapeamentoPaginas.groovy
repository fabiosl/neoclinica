

/**
 * Request Map domain class.
 */
class MapeamentoPaginas {

	String url
	String configAttribute

	static constraints = {
		url(blank: false, unique: true)
		configAttribute(blank: false)
	}
}
