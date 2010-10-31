
<%@ page import="core.TipoProcedimentoMedico" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'tipoProcedimentoMedico.label', default: 'TipoProcedimentoMedico')}" />
        <title>Lista (Tipos de Procedimento Medico)</title>
    </head>
    <body>
        <div class="nav">
        	<span class="menuButton"><a class="voltar" href="javascript:history.back()">Voltar</a></span>
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="create" action="create">Novo Tipo de Procedimento</g:link></span>
        </div>
        <div class="body">
            <h1>Lista (Tipos de Procedimento Medico)</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                            <g:sortableColumn property="id" title="${message(code: 'tipoProcedimentoMedico.id.label', default: 'Id')}" />
                            <g:sortableColumn property="nome" title="${message(code: 'tipoProcedimentoMedico.nome.label', default: 'Nome')}" />
                            <g:sortableColumn property="valorBase" title="${message(code: 'tipoProcedimentoMedico.valorBase.label', default: 'Valor Sugerido')}" />
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${tipoProcedimentoMedicoInstanceList}" status="i" var="tipoProcedimentoMedicoInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                            <td><g:link action="show" id="${tipoProcedimentoMedicoInstance.id}">${fieldValue(bean: tipoProcedimentoMedicoInstance, field: "id")}</g:link></td>
                            <td>${fieldValue(bean: tipoProcedimentoMedicoInstance, field: "nome")}</td>
                            <td>${formatNumber(number : tipoProcedimentoMedicoInstance?.valorBase)}</td>
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${tipoProcedimentoMedicoInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
