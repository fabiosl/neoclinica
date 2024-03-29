<%@ page import="core.Lente" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'lente.label', default: 'Lente')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
        	<span class="menuButton"><a class="voltar" href="javascript:history.back()">Voltar</a></span>
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.show.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" id="lenteCriadaMessage">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>
                       <tr class="prop">
                            <td valign="top" class="name"><g:message code="lente.id.label" default="Id" /></td>
                            <td valign="top" class="value">${fieldValue(bean: lenteInstance, field: "id")}</td>
                        </tr>
                       <tr class="prop">
                            <td valign="top" class="name"><g:message code="lente.tipo.label" default="Tipo de Lente" /></td>
                            <td valign="top" class="value">${fieldValue(bean: lenteInstance, field: "tipo")}</td>
                        </tr>
                       <tr class="prop">
                            <td valign="top" class="name"><g:message code="lente.quantidade.label" default="Quantidade em Estoque" /></td>
                            <td valign="top" class="value">${fieldValue(bean: lenteInstance, field: "quantidade")}</td>
                        </tr>
                       <tr class="prop">
                            <td valign="top" class="name"><g:message code="lente.valor.label" default="Valor de Venda" /></td>
                            <td valign="top" class="value">${formatNumber(number : fieldValue(bean: lenteInstance, field: "valor"))}</td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <g:hiddenField name="id" value="${lenteInstance?.id}" />
                    <span class="button"><g:actionSubmit id="editar" class="edit" action="edit" value="${message(code: 'default.button.edit.label', default: 'Edit')}" /></span>
                	<span class="button"><g:actionSubmit id="deletar" class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}"  /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
