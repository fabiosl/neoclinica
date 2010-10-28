
<%@ page import="core.ProcedimentoMedico" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'procedimentoMedico.label', default: 'ProcedimentoMedico')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="create" action="create" params="[idPaciente : paciente.id]">Cadastrar novo Procedimento para ${paciente}</g:link></span>
        </div>
        <div class="body">
            <h1>Lista de Procedimentos do(a) paciente ${paciente}</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                            <g:sortableColumn property="id" title="${message(code: 'procedimentoMedico.id.label', default: 'Id')}" params="[idPaciente : paciente.id]" />
                            <g:sortableColumn property="valor" title="${message(code: 'procedimentoMedico.valor.label', default: 'Valor')}" params="[idPaciente : paciente.id]" />
                            <g:sortableColumn property="tipo" title="${message(code: 'procedimentoMedico.tipo.label', default: 'Tipo')}" params="[idPaciente : paciente.id]" />
                            <g:sortableColumn property="data" title="${message(code: 'procedimentoMedico.data.label', default: 'Data')}" params="[idPaciente : paciente.id]" />
                            <g:sortableColumn property="informacoes" title="${message(code: 'procedimentoMedico.informacoes.label', default: 'Informa&ccedil;&otilde;es')}" params="[idPaciente : paciente.id]" />
                            <g:sortableColumn property="paciente" title="${message(code: 'procedimentoMedico.paciente.label', default: 'Paciente')}" params="[idPaciente : paciente.id]" />
                            <g:sortableColumn property="medico" title="${message(code: 'procedimentoMedico.medico.label', default: 'Medico')}" params="[idPaciente : paciente.id]" />
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${procedimentoMedicoInstanceList}" status="i" var="procedimentoMedicoInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                            <td><g:link action="show" id="${procedimentoMedicoInstance.id}">${fieldValue(bean: procedimentoMedicoInstance, field: "id")}</g:link></td>
                            <td>${fieldValue(bean: procedimentoMedicoInstance, field: "valor")}</td>
                            <td>${fieldValue(bean: procedimentoMedicoInstance, field: "tipo")}</td>
                            <td><g:formatDate format="dd/MM/yyyy - hh:mm" date="${procedimentoMedicoInstance.data}" /></td>
                            <td>${fieldValue(bean: procedimentoMedicoInstance, field: "informacoes")}</td>
                            <td>${fieldValue(bean: procedimentoMedicoInstance, field: "paciente")}</td>
                            <td>${fieldValue(bean: procedimentoMedicoInstance, field: "medico")}</td>
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${procedimentoMedicoInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
