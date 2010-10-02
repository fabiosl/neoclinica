
<%@ page import="core.Paciente" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'paciente.label', default: 'Paciente')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${pacienteInstance}">
            <div class="errors">
                <g:renderErrors bean="${pacienteInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <g:hiddenField name="id" value="${pacienteInstance?.id}" />
                <g:hiddenField name="version" value="${pacienteInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="nome"><g:message code="paciente.nome.label" default="Nome (*)" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: pacienteInstance, field: 'nome', 'errors')}">
                                    <g:textField name="nome" maxlength="100" value="${pacienteInstance?.nome}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="endereco"><g:message code="paciente.endereco.label" default="Endere&ccedil;o" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: pacienteInstance, field: 'endereco', 'errors')}">
                                    <g:textArea name="endereco" cols="40" rows="5" value="${pacienteInstance?.endereco}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="telefone"><g:message code="paciente.telefone.label" default="Telefone" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: pacienteInstance, field: 'telefone', 'errors')}">
                                    <g:textField name="telefone" maxlength="15" value="${pacienteInstance?.telefone}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="sexo"><g:message code="paciente.sexo.label" default="Sexo (*)" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: pacienteInstance, field: 'sexo', 'errors')}">
                                    <g:select name="sexo" from="${core.Sexo?.values()}" value="${pacienteInstance?.sexo}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="nascimento"><g:message code="paciente.nascimento.label" default="Data de Nascimento (*)" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: pacienteInstance, field: 'nascimento', 'errors')}">
                                    <g:datePicker name="nascimento" precision="day" value="${pacienteInstance?.nascimento}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="profissao"><g:message code="paciente.profissao.label" default="Profiss&atilde;o" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: pacienteInstance, field: 'profissao', 'errors')}">
                                    <g:textField name="profissao" value="${pacienteInstance?.profissao}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="rg"><g:message code="paciente.rg.label" default="RG" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: pacienteInstance, field: 'rg', 'errors')}">
                                    <g:textField name="rg" value="${pacienteInstance?.rg}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="informacoesAdicionais"><g:message code="paciente.informacoesAdicionais.label" default="Informa&ccedil;&otilde;es Adicionais" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: pacienteInstance, field: 'informacoesAdicionais', 'errors')}">
                                    <g:textArea name="informacoesAdicionais" cols="40" rows="5" value="${pacienteInstance?.informacoesAdicionais}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="convenio"><g:message code="paciente.convenio.label" default="Conv&ecirc;nio" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: pacienteInstance, field: 'convenio', 'errors')}">
                                    <g:select name="convenio.id" from="${core.Convenio.list()}" optionKey="id" value="${pacienteInstance?.convenio?.id}" noSelection="['null': '']" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="idExterno"><g:message code="paciente.idExterno.label" default="ID Externo" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: pacienteInstance, field: 'idExterno', 'errors')}">
                                    <g:textField name="idExterno" value="${fieldValue(bean: pacienteInstance, field: 'idExterno')}" />
                                </td>
                            </tr>
                        
                        </tbody>
                    </table>
                </div>
                
                <g:message code="paciente.observacoes" default="" />

			    <div class="buttons">
                    <span class="button"><g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
