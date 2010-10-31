
<%@ page import="core.Fornecedor" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'fornecedor.label', default: 'Fornecedor')}" />
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
                        
                            <g:sortableColumn property="id" title="${message(code: 'fornecedor.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="nome" title="${message(code: 'fornecedor.nome.label', default: 'Nome')}" />
                        
                            <g:sortableColumn property="endereco" title="${message(code: 'fornecedor.endereco.label', default: 'Endere&ccedil;o')}" />
                        
                            <g:sortableColumn property="cnpj" title="${message(code: 'fornecedor.cnpj.label', default: 'CNPJ')}" />
                        
                            <g:sortableColumn property="telefone" title="${message(code: 'fornecedor.telefone.label', default: 'Telefone')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${fornecedorInstanceList}" status="i" var="fornecedorInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                            <td><g:link action="show" id="${fornecedorInstance.id}">${fieldValue(bean: fornecedorInstance, field: "id")}</g:link></td>
                            <td>${fieldValue(bean: fornecedorInstance, field: "nome")}</td>
                            <td>${fieldValue(bean: fornecedorInstance, field: "endereco")}</td>
                            <td>${fieldValue(bean: fornecedorInstance, field: "cnpj")}</td>
                            <td>${fieldValue(bean: fornecedorInstance, field: "telefone")}</td>
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${fornecedorInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
