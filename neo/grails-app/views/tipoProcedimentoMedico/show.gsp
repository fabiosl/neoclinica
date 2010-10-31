
<%@ page import="core.TipoProcedimentoMedico" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'tipoProcedimentoMedico.label', default: 'TipoProcedimentoMedico')}" />
        <title>Ver Tipo de Procedimento Medico</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="list" action="list">Lista (Tipos de Procedimento Medico)</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">Novo Tipo de Procedimento</g:link></span>
        </div>
        <div class="body">
            <h1>Ver Tipo de Procedimento Medico</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>
                     
                       <tr class="prop">
                            <td valign="top" class="name"><g:message code="tipoProcedimentoMedico.id.label" default="Id" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: tipoProcedimentoMedicoInstance, field: "id")}</td>
                            
                        </tr>
                     
                       <tr class="prop">
                            <td valign="top" class="name"><g:message code="tipoProcedimentoMedico.nome.label" default="Nome" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: tipoProcedimentoMedicoInstance, field: "nome")}</td>
                            
                        </tr>
                     
                       <tr class="prop">
                            <td valign="top" class="name"><g:message code="tipoProcedimentoMedico.valorBase.label" default="Valor Sugerido" /></td>
                            
                            <td valign="top" class="value">${formatNumber(number : tipoProcedimentoMedicoInstance?.valorBase)}</td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <g:hiddenField name="id" value="${tipoProcedimentoMedicoInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" action="edit" value="${message(code: 'default.button.edit.label', default: 'Edit')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
