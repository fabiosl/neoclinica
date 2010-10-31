
<%@ page import="core.Compra" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'compra.label', default: 'Compra')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
           	<span class="menuButton"><a class="voltar" href="javascript:history.back()">Voltar</a></span>
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${compraInstance}">
            <div class="errors">
                <g:renderErrors bean="${compraInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <g:hiddenField name="id" value="${compraInstance?.id}" />
                <g:hiddenField name="version" value="${compraInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="valor"><g:message code="compra.valor.label" default="Valor (*)" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: compraInstance, field: 'valor', 'errors')}">
                                    <g:textField name="valor" value="${fieldValue(bean: compraInstance, field: 'valor')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="dataPedido"><g:message code="compra.dataPedido.label" default="Data Pedido (*)" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: compraInstance, field: 'dataPedido', 'errors')}">
                                    <g:datePicker name="dataPedido" precision="minute" value="${compraInstance?.dataPedido}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="paciente"><g:message code="compra.paciente.label" default="Paciente (*)" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: compraInstance, field: 'paciente', 'errors')}">
                                    <g:select name="paciente.id" from="${core.Paciente.list()}" optionKey="id" value="${compraInstance?.paciente?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="dataRecebimento"><g:message code="compra.dataRecebimento.label" default="Data Recebimento (*)" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: compraInstance, field: 'dataRecebimento', 'errors')}">
                                    <g:datePicker name="dataRecebimento" precision="minute" value="${compraInstance?.dataRecebimento}"  />
                                </td>
                            </tr>
                        
                        </tbody>
                    </table>
                </div>
                
                <g:message code="compra.observacoes" default="" />

			    <div class="buttons">
                    <span class="button"><g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
