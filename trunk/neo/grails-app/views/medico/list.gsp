
<%@ page import="core.Medico" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'medico.label', default: 'Medico')}" />
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
                            <g:sortableColumn property="id" title="${message(code: 'medico.id.label', default: 'Id')}" />
                            <g:sortableColumn property="userRealName" title="${message(code: 'medico.userRealName.label', default: 'Nome')}" />
                            <g:sortableColumn property="crm" title="${message(code: 'medico.crm.label', default: 'CRM')}" />
                            <g:sortableColumn property="especialidade" title="${message(code: 'medico.especialidade.label', default: 'Especialidade')}" />
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${medicoInstanceList}" status="i" var="medicoInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                            <td><g:link action="show" id="${medicoInstance.id}">${fieldValue(bean: medicoInstance, field: "id")}</g:link></td>
                            <td>${fieldValue(bean: medicoInstance, field: "userRealName")}</td>
                            <td>${fieldValue(bean: medicoInstance, field: "crm")}</td>
                            <td>${fieldValue(bean: medicoInstance, field: "especialidade")}</td>
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${medicoInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
