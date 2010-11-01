
<%@ page import="core.Compra" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'compra.label', default: 'Compra')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
          	<span class="menuButton"><a class="voltar" href="javascript:history.back()">Voltar</a></span>
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
        </div>
        <div class="body">
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${compraInstance}">
            <div class="errors">
                <g:renderErrors bean="${compraInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:hasErrors bean="${compraInstance.pagamento}">
            <div class="errors">
                <g:renderErrors bean="${compraInstance.pagamento}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="dataPedido"><g:message code="compra.dataPedido.label" default="Data do Pedido (*)" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: compraInstance, field: 'dataPedido', 'errors')}">
                                    <g:datePicker name="dataPedido" precision="day" value="${compraInstance?.dataPedido}"  />
                                </td>
                            </tr>
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="paciente"><g:message code="compra.paciente.label" default="Paciente (*)" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: compraInstance, field: 'paciente', 'errors')}">
                                	<g:if test="${pacientePreDefinido == null}">
                                		<g:select name="paciente.id" from="${core.Paciente.list()}" optionKey="id" value="${compraInstance?.paciente?.id}"  />
                                	</g:if>
                                	<g:else>
                                		<g:select name="paciente.id" from="${[pacientePreDefinido]}" optionKey="id" value="${pacientePreDefinido?.id}" />
                                	</g:else>
                                </td>
                            </tr>
                          <tr class="prop">
                                <td valign="top" class="name">
                                    <g:message code="NO-CODE" default="Quantidade de Parcelas (*)" />
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: compraInstance.pagamento, field: 'pagamento', 'errors')}">
                                    <g:select name="quantidadeDeParcelas" from="${2..24}" noSelection="[ 1 : 'A Vista']"/>
                                </td>
                            </tr>
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <g:message code="NO-CODE" default="Forma de Pagamento (*)" />
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: compraInstance.pagamento, field: 'formaDePagamento', 'errors')}">
                                    <g:select name="formaDePagamento" from="${core.FormaDePagamento?.values()}" value="${procedimentoMedicoInstance?.pagamento?.formaDePagamento}"  />
                                </td>
                            </tr>
                            
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <g:message code="NO-CODE" default="Cart&atilde;o" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: compraInstance.pagamento, field: 'formaDePagamento', 'errors')}">
                                    <g:textField name="cartao" value="${fieldValue(bean: compraInstance.pagamento, field: 'cartao')}" />
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                
                <g:message code="compra.observacoes" default="" />
                
                <div class="buttons">
                    <span class="button"><g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
