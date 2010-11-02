
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
                        
                            <g:sortableColumn property="quantidade" title="${message(code: 'fornecimento.quantidade.label', default: 'Quantidade')}" />
                        
                            <g:sortableColumn property="preco" title="${message(code: 'fornecimento.preco.label', default: 'Preco')}" />
                        
                            <g:sortableColumn property="dataPedido" title="${message(code: 'fornecimento.dataPedido.label', default: 'Data Pedido')}" />
                        
                            <th><g:message code="fornecimento.f.label" default="Fornecedor" /></th>
                   	    
                            <th><g:message code="fornecimento.l.label" default="Lente" /></th>
                   	    
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${fornecimentoInstanceList}" status="i" var="fornecimentoInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${fornecimentoInstance.id}">${fieldValue(bean: fornecimentoInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: fornecimentoInstance, field: "quantidade")}</td>
                        
                            <td>${formatNumber(number : fieldValue(bean: fornecimentoInstance, field: "preco"))}</td>
                        
                            <td><g:formatDate date="${fornecimentoInstance.dataPedido}" /></td>
                        
                            <td>${fieldValue(bean: fornecimentoInstance, field: "f")}</td>
                        
                            <td>${fieldValue(bean: fornecimentoInstance, field: "l")}</td>
                        
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
