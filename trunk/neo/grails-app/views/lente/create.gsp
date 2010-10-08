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
            <g:hasErrors bean="${lenteInstance}">
            <div class="errors">
                <g:renderErrors bean="${lenteInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" name="formAddLente" >
                <div class="dialog">
                    <table>
                        <tbody>
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="nome"><g:message code="lente.tipo.label" default="Tipo da Lente (*)" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: lenteInstance, field: 'nome', 'errors')}">
                                    <g:textField name="tipo" maxlength="100" value="${lenteInstance?.tipo}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="quantidade"><g:message code="lente.quantidade.label" default="Quantidade Adquirida" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: lenteInstance, field: 'quantidade', 'errors')}">
                                    <g:textField name="quantidade" maxlength="15" value="${lenteInstance?.quantidade}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="valor"><g:message code="lente.valor.label" default="Valor de Compra" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: lenteInstance, field: 'valor', 'errors')}">
                                    <g:textField name="valor" maxlength="15" value="${lenteInstance?.valor}" />
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
