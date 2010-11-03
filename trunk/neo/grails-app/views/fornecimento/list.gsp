
<%@ page import="core.Fornecimento" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'fornecimento.label', default: 'Fornecimento')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
        	<span class="menuButton"><a class="voltar" href="javascript:history.back()">Voltar</a></span>
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                            <g:sortableColumn property="id" title="${message(code: 'fornecimento.id.label', default: 'Id')}" />
                            <g:sortableColumn property="dataPedido" title="${message(code: 'fornecimento.dataPedido.label', default: 'Data de Pedido')}" />
                            <g:sortableColumn property="dataRecebimento" title="Situa&ccedil;&atilde;o de Entrega" />
                            <g:sortableColumn property="dataRecebimento" title="${message(code: 'fornecimento.dataRecebimento.label', default: 'Data de Recebimento')}" />
                            <g:sortableColumn property="quantidade" title="${message(code: 'fornecimento.quantidade.label', default: 'Quantidade')}" />
                            <g:sortableColumn property="preco" title="${message(code: 'fornecimento.preco.label', default: 'Pre&ccedil;o')}" />
                            <g:sortableColumn property="fornecedor" title="${message(code: 'fornecimento.fornecedor.label', default: 'Fornecedor')}" />
                            <g:sortableColumn property="lente" title="${message(code: 'fornecimento.lente.label', default: 'Lente')}" />
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${fornecimentoInstanceList}" status="i" var="fornecimentoInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                            <td><g:link action="show" id="${fornecimentoInstance.id}">${fieldValue(bean: fornecimentoInstance, field: "id")}</g:link></td>
                            <td><g:formatDate format="dd/MM/yyyy" date="${fornecimentoInstance.dataPedido}" /></td>
                            <td>${fornecimentoInstance?.statusDeEntrega()}</td>
                            <td><g:formatDate format="dd/MM/yyyy" date="${fornecimentoInstance.dataRecebimento}" /></td>
                            <td>${fieldValue(bean: fornecimentoInstance, field: "quantidade")}</td>
                            <td>${formatNumber(number : fieldValue(bean: fornecimentoInstance, field: "preco"))}</td>
                            <td>${fieldValue(bean: fornecimentoInstance, field: "fornecedor")}</td>
                            <td>${fieldValue(bean: fornecimentoInstance, field: "lente")}</td>
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${fornecimentoInstanceTotal}" />
            </div>
        </div>
    </body>
</html>