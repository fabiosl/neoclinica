security {
	// see DefaultSecurityConfig.groovy for all settable/overridable properties
	active = true
	
	loginUserDomainClass = "Usuario"
	authorityDomainClass = "Hierarquia"
	
	useRequestMapDomainClass = false
	
	requestMapString = """
	CONVERT_URL_TO_LOWERCASE_BEFORE_COMPARISON
	PATTERN_TYPE_APACHE_ANT
	/main.gsp=ROLE_ADMIN, ROLE_FUNCIONARIO, ROLE_MANUTENCAO
	/paciente/**=ROLE_ADMIN, ROLE_FUNCIONARIO
	/lente/**=ROLE_ADMIN, ROLE_FUNCIONARIO
	/fornecedor/**=ROLE_ADMIN, ROLE_FUNCIONARIO
	/usuario/**=ROLE_ADMIN, ROLE_MANUTENCAO
	"""
}
