
<%@ page import="core.Fornecimento" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'fornecimento.label', default: 'Fornecimento')}" />
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
                            <td valign="top" class="name"><g:message code="fornecimento.id.label" default="Id" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: fornecimentoInstance, field: "id")}</td>
                            
                        </tr>
                     
                       <tr class="prop">
                            <td valign="top" class="name"><g:message code="fornecimento.quantidade.label" default="Quantidade" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: fornecimentoInstance, field: "quantidade")}</td>
                            
                        </tr>
                     
                       <tr class="prop">
                            <td valign="top" class="name"><g:message code="fornecimento.preco.label" default="Preco" /></td>
                            
                            <td valign="top" class="value">${formatNumber(number : fieldValue(bean: fornecimentoInstance, field: "preco"))}</td>
                            
                        </tr>
                     
                       <tr class="prop">
                            <td valign="top" class="name"><g:message code="fornecimento.dataPedido.label" default="Data Pedido" /></td>
                            
                            <td valign="top" class="value"><g:formatDate date="${fornecimentoInstance?.dataPedido}" /></td>
                            
                        </tr>
                     
                       <tr class="prop">
                            <td valign="top" class="name"><g:message code="fornecimento.f.label" default="Fornecedor" /></td>
                            
                            <td valign="top" class="value"><g:link controller="fornecedor" action="show" id="${fornecimentoInstance?.f?.id}">${fornecimentoInstance?.f?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                     
                       <tr class="prop">
                            <td valign="top" class="name"><g:message code="fornecimento.l.label" default="Lente" /></td>
                            
                            <td valign="top" class="value"><g:link controller="lente" action="show" id="${fornecimentoInstance?.l?.id}">${fornecimentoInstance?.l?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <g:hiddenField name="id" value="${fornecimentoInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" action="edit" value="${message(code: 'default.button.edit.label', default: 'Edit')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
