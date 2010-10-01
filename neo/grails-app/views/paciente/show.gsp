
<%@ page import="core.Paciente" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'paciente.label', default: 'Paciente')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/paciente')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
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
                            <td valign="top" class="name"><g:message code="paciente.id.label" default="Id" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: pacienteInstance, field: "id")}</td>
                            
                        </tr>
                     
                       <tr class="prop">
                            <td valign="top" class="name"><g:message code="paciente.nome.label" default="Nome" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: pacienteInstance, field: "nome")}</td>
                            
                        </tr>
                     
                       <tr class="prop">
                            <td valign="top" class="name"><g:message code="paciente.endereco.label" default="Endereco" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: pacienteInstance, field: "endereco")}</td>
                            
                        </tr>
                     
                       <tr class="prop">
                            <td valign="top" class="name"><g:message code="paciente.telefone.label" default="Telefone" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: pacienteInstance, field: "telefone")}</td>
                            
                        </tr>
                     
                       <tr class="prop">
                            <td valign="top" class="name"><g:message code="paciente.sexo.label" default="Sexo" /></td>
                            
                            <td valign="top" class="value">${pacienteInstance?.sexo?.encodeAsHTML()}</td>
                            
                        </tr>
                     
                       <tr class="prop">
                            <td valign="top" class="name"><g:message code="paciente.nascimento.label" default="Nascimento" /></td>
                            
                            <td valign="top" class="value"><g:formatDate format="dd-MM-yyyy" date="${pacienteInstance?.nascimento}" /></td>
                            
                        </tr>
                     
                       <tr class="prop">
                            <td valign="top" class="name"><g:message code="paciente.profissao.label" default="Profissao" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: pacienteInstance, field: "profissao")}</td>
                            
                        </tr>
                     
                       <tr class="prop">
                            <td valign="top" class="name"><g:message code="paciente.rg.label" default="Rg" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: pacienteInstance, field: "rg")}</td>
                            
                        </tr>
                     
                       <tr class="prop">
                            <td valign="top" class="name"><g:message code="paciente.informacoesAdicionais.label" default="Informacoes Adicionais" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: pacienteInstance, field: "informacoesAdicionais")}</td>
                            
                        </tr>
                     
                       <tr class="prop">
                            <td valign="top" class="name"><g:message code="paciente.convenio.label" default="Convenio" /></td>
                            
                            <td valign="top" class="value"><g:link controller="convenio" action="show" id="${pacienteInstance?.convenio?.id}">${pacienteInstance?.convenio?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                     
                       <tr class="prop">
                            <td valign="top" class="name"><g:message code="paciente.idExterno.label" default="Id Externo" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: pacienteInstance, field: "idExterno")}</td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <g:hiddenField name="id" value="${pacienteInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" action="edit" value="${message(code: 'default.button.edit.label', default: 'Edit')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
