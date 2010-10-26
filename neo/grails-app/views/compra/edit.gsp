<%@ page import="core.Lente"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="layout" content="main" />
<g:set var="entityName"
	value="${message(code: 'lente.label', default: 'Lente')}" />
<title><g:message code="default.edit.label" args="[entityName]" /></title>
</head>
<body>
<div class="nav"><span class="menuButton"><a class="home"
	href="${createLink(uri: '/')}"><g:message code="default.home.label" /></a></span>
<span class="menuButton"><g:link class="list" action="list">
	<g:message code="default.list.label" args="[entityName]" />
</g:link></span></div>
<div class="body">
<h1><g:message code="default.edit.label" args="[entityName]" /></h1>
<g:if test="${flash.message}">
	<div class="message">
	${flash.message}
	</div>
</g:if> <g:hasErrors bean="${lenteInstance}">
	<div class="errors"><g:renderErrors bean="${lenteInstance}"
		as="list" /></div>
</g:hasErrors> <g:form method="post" name="formEditLente">
	<g:hiddenField name="id" value="${lenteInstance?.id}" />
	<g:hiddenField name="version" value="${lenteInstance?.version}" />
	<div class="dialog">
	<table>
		<tbody>
			<tr class="prop">
				<td valign="top" class="tipo"><label for="tipo"><g:message
					code="paciente.tipo.label" default="Tipo (*)" /></label></td>
				<td valign="top"
					class="value ${hasErrors(bean: pacienteInstance, field: 'tipo', 'errors')}">
				<g:textField name="tipo" maxlength="100"
					value="${lenteInstance?.tipo}" /></td>
			</tr>
			<tr class="prop">
			<td valign="top" class="name"><label for="quantidade"><g:message
				code="lente.quantidade.label" default="Quantidade em Estoque" /></label></td>
			<td valign="top"
				class="value ${hasErrors(bean: lenteInstance, field: 'quantidade', 'errors')}">
			<g:textField name="quantidade" maxlength="15"
				value="${lenteInstance?.quantidade}" /></td>
			</tr>

			<tr class="prop">
				<td valign="top" class="name"><label for="valor"><g:message
					code="lente.valor.label" default="Valor de Venda" /></label></td>
				<td valign="top"
					class="value ${hasErrors(bean: lenteInstance, field: 'valor', 'errors')}">
				<g:textField name="valor" maxlength="15"
					value="${lenteInstance?.valor}" /></td>
			</tr>
		</tbody>
	</table>
	</div>

	<g:message code="paciente.observacoes" default="" />

	<div class="buttons"><span class="button"><g:actionSubmit
		class="save" id="atualizar" action="update"
		value="${message(code: 'default.button.update.label', default: 'Update')}" /></span>
	<span class="button"><g:actionSubmit class="delete"
		action="delete"
		value="${message(code: 'default.button.delete.label', default: 'Delete')}"
		onclick=";" /></span></div>
</g:form></div>
</body>
</html>
