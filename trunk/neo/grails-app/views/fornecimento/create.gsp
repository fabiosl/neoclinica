<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="core.Lente" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'lente.label', default: 'Lentes')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
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
            <g:form action="save" method="post" name="formAddFornecimento" >
                <div class="dialog">
                    <table>
                        <tbody>
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="nome"><g:message code="fornecimento.quantidade.label" default="Quantidade Pedida (*)" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: fornecimentoInstance, field: 'quantidade', 'errors')}">
                                    <g:textField name="quantiadade" maxlength="15" value="${fornecimentoInstance?.quantidade}" />
                                </td>
                            </tr>
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="preco"><g:message code="fornecimento.valor.label" default="Valor do Pedido" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: fornecimentoInstance, field: 'preco', 'errors')}">
                                    <g:textField name="preco" maxlength="15" value="${fornecimentoInstance?.preco}" />
                                </td>
                            </tr>
                            
                             <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="valor"><g:message code="fornecimento.l.label" default="Lente Pedida" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: fornecimentoInstance, field: 'l', 'errors')}">
                                    	<g:select name="lente" noSelection="${['null':'Escolha um tipo de lente...']}" from="${validos}" />
                                </td>
                            </tr>
                            
                              <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="valor"><g:message code="fornecimento.f.label" default="Fornecedor do Produto" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: fornecimentoInstance, field: 'f', 'errors')}">
                                    	<g:select name="fornecedor" noSelection="${['null':'Escolha um fornecedor...']}" from="${validos2}" />
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
