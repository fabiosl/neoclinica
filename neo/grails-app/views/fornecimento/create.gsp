
<%@ page import="core.Fornecimento" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'fornecimento.label', default: 'Fornecimento')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
        	<span class="menuButton"><a class="voltar" href="javascript:history.back()">Voltar</a></span>
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${fornecimentoInstance}">
            <div class="errors">
                <g:renderErrors bean="${fornecimentoInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="dataPedido"><g:message code="fornecimento.dataPedido.label" default="Data do Pedido (*)" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: fornecimentoInstance, field: 'dataPedido', 'errors')}">
                                    <g:datePicker name="dataPedido" precision="day" value="${fornecimentoInstance?.dataPedido}"  />
                                </td>
                            </tr>
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="quantidade"><g:message code="fornecimento.quantidade.label" default="Quantidade (*)" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: fornecimentoInstance, field: 'quantidade', 'errors')}">
                                    <g:textField name="quantidade" value="${fieldValue(bean: fornecimentoInstance, field: 'quantidade')}" />
                                </td>
                            </tr>
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="preco"><g:message code="fornecimento.preco.label" default="Pre&ccedil;o (*)" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: fornecimentoInstance, field: 'preco', 'errors')}">
                                    <g:textField name="preco" value="${formatNumber(number : fieldValue(bean: fornecimentoInstance, field: 'preco'))}" />
                                </td>
                            </tr>
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="fornecedor"><g:message code="fornecimento.fornecedor.label" default="Fornecedor (*)" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: fornecimentoInstance, field: 'fornecedor', 'errors')}">
                                    <g:select name="fornecedor.id" from="${core.Fornecedor.list()}" optionKey="id" value="${fornecimentoInstance?.fornecedor?.id}"  />
                                </td>
                            </tr>
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="lente"><g:message code="fornecimento.lente.label" default="Lente (*)" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: fornecimentoInstance, field: 'lente', 'errors')}">
                                    <g:select name="lente.id" from="${core.Lente.list()}" optionKey="id" value="${fornecimentoInstance?.lente?.id}"  />
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                
                <div class="buttons">
                    <span class="button"><g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
