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
	/paciente/create=ROLE_ADMIN, ROLE_FUNCIONARIO
	/paciente/edit=ROLE_ADMIN, ROLE_FUNCIONARIO
	/paciente/show=ROLE_ADMIN, ROLE_FUNCIONARIO
	/paciente/list=ROLE_ADMIN, ROLE_FUNCIONARIO
	/lente/create=ROLE_ADMIN, ROLE_FUNCIONARIO
	/lente/edit=ROLE_ADMIN, ROLE_FUNCIONARIO
	/lente/show=ROLE_ADMIN, ROLE_FUNCIONARIO
	/lente/list=ROLE_ADMIN, ROLE_FUNCIONARIO
	/fornecedor/create=ROLE_ADMIN, ROLE_FUNCIONARIO
	/fornecedor/edit=ROLE_ADMIN, ROLE_FUNCIONARIO
	/fornecedor/show=ROLE_ADMIN, ROLE_FUNCIONARIO
	/fornecedor/list=ROLE_ADMIN, ROLE_FUNCIONARIO
	/usuario/create=ROLE_ADMIN, ROLE_MANUTENCAO
	/usuario/edit=ROLE_ADMIN, ROLE_MANUTENCAO
	/usuario/show=ROLE_ADMIN, ROLE_MANUTENCAO
	/usuario/list=ROLE_ADMIN, ROLE_MANUTENCAO
	"""
}
