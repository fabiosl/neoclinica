
<%@ page import="core.Convenio" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'convenio.label', default: 'Convenio')}" />
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
            <g:hasErrors bean="${convenioInstance}">
            <div class="errors">
                <g:renderErrors bean="${convenioInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="nome"><g:message code="convenio.nome.label" default="Nome" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: convenioInstance, field: 'nome', 'errors')}">
                                    <g:textField name="nome" value="${convenioInstance?.nome}" />
                                </td>
                            </tr>
                        
                        </tbody>
                    </table>
                </div>
                
                <g:message code="convenio.observacoes" default="" />
                
                <div class="buttons">
                    <span class="button"><g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
