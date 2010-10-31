
<%@ page import="core.ProcedimentoMedico" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'procedimentoMedico.label', default: 'ProcedimentoMedico')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
        	<span class="menuButton"><a class="voltar" href="javascript:history.back()">Voltar</a></span>
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
       		<span class="menuButton"><g:link class="list_proc" action="list" params="[idPaciente : procedimentoMedicoInstance.paciente.id]">Listar procedimentos de ${procedimentoMedicoInstance.paciente}</g:link></span>
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
                            <td valign="top" class="name"><g:message code="procedimentoMedico.id.label" default="Id" /></td>
                            <td valign="top" class="value">${fieldValue(bean: procedimentoMedicoInstance, field: "id")}</td>
                        </tr>
                       <tr class="prop">
                            <td valign="top" class="name"><g:message code="procedimentoMedico.valor.label" default="Valor" /></td>
                            <td valign="top" class="value">${formatNumber(number : procedimentoMedicoInstance.valor)}</td>
                        </tr>
                       <tr class="prop">
                            <td valign="top" class="name"><g:message code="procedimentoMedico.tipo.label" default="Tipo" /></td>
                            <td valign="top" class="value"><g:link controller="tipoProcedimentoMedico" action="show" id="${procedimentoMedicoInstance?.tipo?.id}">${procedimentoMedicoInstance?.tipo?.encodeAsHTML()}</g:link></td>
                       </tr>
                       <tr class="prop">
                            <td valign="top" class="name"><g:message code="procedimentoMedico.data.label" default="Hor&aacute;rio" /></td>
                            <td valign="top" class="value"><g:formatDate date="${procedimentoMedicoInstance?.data}" /></td>
                        </tr>
                       <tr class="prop">
                            <td valign="top" class="name"><g:message code="procedimentoMedico.informacoes.label" default="Informa&ccedil;&otilde;es" /></td>
                            <td valign="top" class="value">${fieldValue(bean: procedimentoMedicoInstance, field: "informacoes")}</td>
                        </tr>
                       <tr class="prop">
                            <td valign="top" class="name"><g:message code="procedimentoMedico.paciente.label" default="Paciente" /></td>
                            <td valign="top" class="value"><g:link controller="paciente" action="show" id="${procedimentoMedicoInstance?.paciente?.id}">${procedimentoMedicoInstance?.paciente?.encodeAsHTML()}</g:link></td>
                        </tr>
                       <tr class="prop">
                            <td valign="top" class="name"><g:message code="procedimentoMedico.medico.label" default="M&eacute;dico" /></td>
                            <td valign="top" class="value"><g:link controller="medico" action="show" id="${procedimentoMedicoInstance?.medico?.id}">${procedimentoMedicoInstance?.medico?.encodeAsHTML()}</g:link></td>
                        </tr>
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="procedimentoMedico.medico.label" default="Pagamento" /></td>
                            <td valign="top" class="value">
                                <table>
                    				<tbody>
                       					<tr class="prop">
                            				<td width="150"><i>${procedimentoMedicoInstance?.pagamento?.formaDePagamento()}</i></td>
                            				<td width="100"><i>Pago</i></td>
                            				<td width="150"><i>Data de Pagamento</i></td>
                            				<td width="100"><i>Valor</i></td>
                       					</tr>
                       					<g:each in="${procedimentoMedicoInstance?.pagamento?.prestacoes}">
                            					<tr class="prop">
                            						<td>${it.posicao + 1}</td>
                            						<td><g:formatBoolean boolean="${it.paga}"/></td>
                            						<g:if test="${it.isPaga()}">
                            							<td><g:formatDate format="dd-MM-yyyy" date="${it.dataDePagamento}" /></td>
                            							<td>${formatNumber(number : it.valor)}</td>
                            						</g:if>
                            						<g:else>
                            							<td>-</td>
                            							<td>-</td>
                            						</g:else>
                       							</tr>
                            			</g:each>
                    				</tbody>
                				</table>
                            </td>
                        </tr>
                    </tbody>
                </table>
                

            </div>
            <div class="buttons">
                <g:form>
                    <g:hiddenField name="id" value="${procedimentoMedicoInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" action="edit" value="${message(code: 'default.button.edit.label', default: 'Edit')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
