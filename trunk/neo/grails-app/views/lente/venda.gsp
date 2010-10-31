<%@ page import="core.Lente"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="layout" content="main" />
<g:set var="entityName"
	value="${message(code: 'lente.label', default: 'Lente')}" />
<title><g:message code="default.venda.label" args="[entityName]" /></title>
</head>
<body>
<div class="nav">
<span class="menuButton"><a class="voltar" href="javascript:history.back()">Voltar</a></span>
<span class="menuButton"><a class="home"
	href="${createLink(uri: '/')}"><g:message code="default.home.label" /></a></span>
</div>
<div class="body">
<h1><g:message code="default.venda.label" args="[entityName]" /></h1>
<g:form action="fazVenda">
	<fieldset>
	<legend>Escolha o tipo de lente vendida</legend>
	<g:select name="lente" noSelection="${['null':'Escolha um tipo de lente...']}" from="${validos}" />
	<br />
	<br />
	<legend>Escolher a quantidade vendida</legend>
	<g:textField name="quantidade" maxlength="20"/>
	<br />
	<br />
	<legend>Valor da venda</legend>
	<g:textField name="valor" maxlength="20"/>
	<br />
	<br />
	<g:submitButton name="submit" value="Cadastrar Venda" />
	<br />
	</fieldset>
	</g:form>
</div>
</body>
</html>
