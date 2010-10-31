
<%@ page import="core.TipoProcedimentoMedico" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'tipoProcedimentoMedico.label', default: 'TipoProcedimentoMedico')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
        	<span class="menuButton"><a class="voltar" href="javascript:history.back()">Voltar</a></span>
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="list" action="list">Lista (Tipos de Procedimento Medico)</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">Novo Tipo de Procedimento</g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${tipoProcedimentoMedicoInstance}">
            <div class="errors">
                <g:renderErrors bean="${tipoProcedimentoMedicoInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <g:hiddenField name="id" value="${tipoProcedimentoMedicoInstance?.id}" />
                <g:hiddenField name="version" value="${tipoProcedimentoMedicoInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="nome"><g:message code="tipoProcedimentoMedico.nome.label" default="Nome (*)" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: tipoProcedimentoMedicoInstance, field: 'nome', 'errors')}">
                                    <g:textField name="nome" value="${tipoProcedimentoMedicoInstance?.nome}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="valorBase"><g:message code="tipoProcedimentoMedico.valorBase.label" default="Valor Sugerido (*)" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: tipoProcedimentoMedicoInstance, field: 'valorBase', 'errors')}">
                                    <g:textField name="valorBase" value="${formatNumber(number : tipoProcedimentoMedicoInstance?.valorBase)}" />
                                </td>
                            </tr>
                        
                        </tbody>
                    </table>
                </div>
                
                <g:message code="tipoProcedimentoMedico.observacoes" default="" />

			    <div class="buttons">
                    <span class="button"><g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
