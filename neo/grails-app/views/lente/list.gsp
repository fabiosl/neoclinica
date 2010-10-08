<%@ page import="core.Lente" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'lente.label', default: 'Lente')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
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
                            <g:sortableColumn property="id" title="${message(code: 'lente.id.label', default: 'Id')}" />
                            <g:sortableColumn property="tipo" title="${message(code: 'lente.tipo.label', default: 'Tipo')}" />
                            <g:sortableColumn property="quantidade" title="${message(code: 'lente.quantidade.quantidade', default: 'Quantidade')}" />
                            <g:sortableColumn property="valor" title="${message(code: 'lente.valor.label', default: 'Valor De Compra')}" />
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${lenteInstanceList}" status="i" var="lenteInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                            <td><g:link action="show" id="${lenteInstance.id}" name="${lenteInstance.id}">${fieldValue(bean: lenteInstance, field: "id")}</g:link></td>
                            <td>${fieldValue(bean: lenteInstance, field: "tipo")}</td>
                            <td>${fieldValue(bean: lenteInstance, field: "quantidade")}</td>
                            <td>${fieldValue(bean: lenteInstance, field: "valor")}</td>
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${lenteInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
