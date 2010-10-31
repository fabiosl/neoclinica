
<%@ page import="core.Compra" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'compra.label', default: 'Compra')}" />
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
                            <g:sortableColumn property="id" title="${message(code: 'compra.id.label', default: 'Id')}" />
                            <g:sortableColumn property="valor" title="${message(code: 'compra.valor.label', default: 'Valor')}" />
                            <g:sortableColumn property="dataPedido" title="${message(code: 'compra.dataPedido.label', default: 'Data Pedido')}" />
                            <g:sortableColumn property="paciente" title="${message(code: 'compra.paciente.label', default: 'Paciente')}" />
                            <g:sortableColumn property="dataRecebimento" title="${message(code: 'compra.dataRecebimento.label', default: 'Data Recebimento')}" />
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${compraInstanceList}" status="i" var="compraInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                            <td><g:link action="show" id="${compraInstance.id}">${fieldValue(bean: compraInstance, field: "id")}</g:link></td>
                            <td>${fieldValue(bean: compraInstance, field: "valor")}</td>
                            <td><g:formatDate date="${compraInstance.dataPedido}" /></td>
                            <td>${fieldValue(bean: compraInstance, field: "paciente")}</td>
                            <td><g:formatDate date="${compraInstance.dataRecebimento}" /></td>
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${compraInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
