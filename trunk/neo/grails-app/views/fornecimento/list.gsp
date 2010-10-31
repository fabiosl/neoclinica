<%@ page import="core.Lente"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="layout" content="main" />
<g:set var="entityName"
	value="${message(code: 'fonecimento.label', default: 'Fornecimento')}" />
<title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
<div class="nav"><span class="menuButton"><a class="voltar"
	href="javascript:history.back()">Voltar</a></span> <span class="menuButton"><a
	class="home" href="${createLink(uri: '/')}"><g:message
	code="default.home.label" /></a></span></div>
<div class="body">
<h1><g:message code="default.list.label" args="[entityName]" /></h1>
<g:if test="${flash.message}">
	<div class="message">
	${flash.message}
	</div>
</g:if>
<div class="list">
<table>
	<thead>
		<tr>
			<g:sortableColumn property="id"
				title="${message(code: 'lente.id.label', default: 'Id')}" />
			<g:sortableColumn property="fornecedor"
				title="${message(code: 'fornecimento.f.label', default: 'Fornecedor')}" />
			<g:sortableColumn property="lente"
				title="${message(code: 'fornecimento.l.label', default: 'Tipo da Lente')}" />
			<g:sortableColumn property="quantidade"
				title="${message(code: 'fornecimento.quantidade.quantidade', default: 'Quantidade Comprada')}" />
			<g:sortableColumn property="preco"
				title="${message(code: 'fornecimento.preco.label', default: 'Preco da Compra')}" />
			<g:sortableColumn property="data"
				title="${message(code: 'fornecimento.dataPedido.label', default: 'Data do Pedido')}" />
		</tr>
	</thead>
	<tbody>
		<g:each in="${fornecimentoInstanceList}" status="i"
			var="fornecimentoInstance">
			<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
				<td><g:link action="show" id="${fornecimentoInstanceList.id}"
					name="${fornecimentoInstanceList.id}">
					${fieldValue(bean: fornecimentoInstanceList, field: "id")}
				</g:link></td>
				<td>
				${fieldValue(bean: fornecimentoInstanceList, field: "f")}
				</td>
				<td>
				${fieldValue(bean: fornecimentoInstanceList, field: "l")}
				</td>
				<td>
				${fieldValue(bean: fornecimentoInstanceList, field: "quantidade")}
				</td>
				<td>
				${fieldValue(bean: fornecimentoInstanceList, field: "preco")}
				</td>
				<td>
				${fieldValue(bean: fornecimentoInstanceList, field: "dataPedido")}
				</td>
			</tr>
		</g:each>
	</tbody>
</table>
</div>
<div class="paginateButtons"><g:paginate
	total="${fornecimentoInstanceTotal}" /></div>
</div>
</body>
</html>
