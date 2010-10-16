
<%@ page import="core.Medico" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'medico.label', default: 'Medico')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${medicoInstance}">
            <div class="errors">
                <g:renderErrors bean="${medicoInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="username"><g:message code="medico.username.label" default="Login (*)" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: medicoInstance, field: 'username', 'errors')}">
                                    <g:textField name="username" value="${medicoInstance?.username}" />
                                </td>
                            </tr>
                            
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="userRealName"><g:message code="medico.userRealName.label" default="Nome (*)" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: medicoInstance, field: 'userRealName', 'errors')}">
                                    <g:textField name="userRealName" value="${medicoInstance?.userRealName}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="passwd"><g:message code="medico.passwd.label" default="Senha (*)" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: medicoInstance, field: 'passwd', 'errors')}">
                                    <input type="password" name="passwd" value="${medicoInstance?.passwd}" />
                                </td>
                            </tr>
                            
                            
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="crm"><g:message code="medico.crm.label" default="CRM" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: medicoInstance, field: 'crm', 'errors')}">
                                    <g:textField name="crm" value="${medicoInstance?.crm}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="especialidade"><g:message code="medico.especialidade.label" default="Especialidade" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: medicoInstance, field: 'especialidade', 'errors')}">
                                    <g:textField name="especialidade" value="${medicoInstance?.especialidade}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="email"><g:message code="medico.email.label" default="Email" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: medicoInstance, field: 'email', 'errors')}">
                                    <g:textField name="email" value="${medicoInstance?.email}" />
                                </td>
                            </tr>
                        
                        </tbody>
                    </table>
                </div>
                
                <g:message code="medico.observacoes" default="" />
                
                <div class="buttons">
                    <span class="button"><g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
