
<%@ page import="core.Fornecedor" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'fornecedor.label', default: 'Fornecedor')}" />
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
            <g:hasErrors bean="${fornecedorInstance}">
            <div class="errors">
                <g:renderErrors bean="${fornecedorInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="nome"><g:message code="fornecedor.nome.label" default="Nome (*)" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: fornecedorInstance, field: 'nome', 'errors')}">
                                    <g:textField name="nome" maxlength="100" value="${fornecedorInstance?.nome}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="endereco"><g:message code="fornecedor.endereco.label" default="Endere&ccedil;o" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: fornecedorInstance, field: 'endereco', 'errors')}">
                                    <g:textArea name="endereco" cols="40" rows="5" value="${fornecedorInstance?.endereco}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="cnpj"><g:message code="fornecedor.cnpj.label" default="CNPJ" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: fornecedorInstance, field: 'cnpj', 'errors')}">
                                    <g:textField name="cnpj" maxlength="15" value="${fornecedorInstance?.cnpj}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="telefone"><g:message code="fornecedor.telefone.label" default="Telefone" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: fornecedorInstance, field: 'telefone', 'errors')}">
                                    <g:textField name="telefone" maxlength="13" value="${fornecedorInstance?.telefone}" />
                                </td>
                            </tr>
                        
                        </tbody>
                    </table>
                </div>
                
                <g:message code="fornecedor.observacoes" default="" />
                
                <div class="buttons">
                    <span class="button"><g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
