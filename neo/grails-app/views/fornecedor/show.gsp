
<%@ page import="core.Fornecedor" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'fornecedor.label', default: 'Fornecedor')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
        	<span class="menuButton"><a class="voltar" href="javascript:history.back()">Voltar</a></span>
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.show.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>
                     
                       <tr class="prop">
                            <td valign="top" class="name"><g:message code="fornecedor.id.label" default="Id" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: fornecedorInstance, field: "id")}</td>
                            
                        </tr>
                     
                       <tr class="prop">
                            <td valign="top" class="name"><g:message code="fornecedor.nome.label" default="Nome" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: fornecedorInstance, field: "nome")}</td>
                            
                        </tr>
                     
                       <tr class="prop">
                            <td valign="top" class="name"><g:message code="fornecedor.endereco.label" default="Endere&ccedil;o" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: fornecedorInstance, field: "endereco")}</td>
                            
                        </tr>
                     
                       <tr class="prop">
                            <td valign="top" class="name"><g:message code="fornecedor.cnpj.label" default="CNPJ" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: fornecedorInstance, field: "cnpj")}</td>
                            
                        </tr>
                     
                       <tr class="prop">
                            <td valign="top" class="name"><g:message code="fornecedor.telefone.label" default="Telefone" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: fornecedorInstance, field: "telefone")}</td>
                            
                        </tr>
                     
                       <tr class="prop">
                            <td valign="top" class="name"><g:message code="fornecedor.lentes.label" default="Lentes Fornecidas" /></td>
                            
                            <td valign="top" style="text-align: left;" class="value">
                                <ul>
                                <g:each in="${fornecedorInstance.lentes}" var="l">
                                    <li><g:link controller="lente" action="show" id="${l.id}">${l?.encodeAsHTML()}</g:link></li>
                                </g:each>
                                </ul>
                            </td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <g:hiddenField name="id" value="${fornecedorInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" action="edit" value="${message(code: 'default.button.edit.label', default: 'Edit')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
