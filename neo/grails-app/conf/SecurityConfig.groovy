security {
	// see DefaultSecurityConfig.groovy for all settable/overridable properties
	active = true
	cacheUsers = false
	
	loginUserDomainClass = "Usuario"
	authorityDomainClass = "Hierarquia"
	
	useRequestMapDomainClass = false
	
	requestMapString = """
	CONVERT_URL_TO_LOWERCASE_BEFORE_COMPARISON
	PATTERN_TYPE_APACHE_ANT
	/main.gsp=ROLE_ADMIN, ROLE_FUNCIONARIO, ROLE_MANUTENCAO
	/configuracoes.gsp=ROLE_ADMIN, ROLE_FUNCIONARIO, ROLE_MANUTENCAO
	/paciente/**=ROLE_ADMIN, ROLE_FUNCIONARIO, ROLE_MANUTENCAO
	/convenio/**=ROLE_ADMIN, ROLE_FUNCIONARIO, ROLE_MANUTENCAO
	/lente/**=ROLE_ADMIN, ROLE_FUNCIONARIO, ROLE_MANUTENCAO
	/fornecedor/**=ROLE_ADMIN, ROLE_FUNCIONARIO, ROLE_MANUTENCAO
	/usuario/alterarsenha=ROLE_ADMIN, ROLE_MANUTENCAO, ROLE_FUNCIONARIO
	/usuario/list=ROLE_ADMIN, ROLE_MANUTENCAO
	/usuario/create**=ROLE_ADMIN, ROLE_MANUTENCAO
	/usuario/delete**=ROLE_ADMIN, ROLE_MANUTENCAO
	/usuario/edit**=ROLE_ADMIN, ROLE_MANUTENCAO
	/usuario/show**=ROLE_ADMIN, ROLE_MANUTENCAO
	"""
}
