
<%@ page import="core.ProcedimentoMedico" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'procedimentoMedico.label', default: 'ProcedimentoMedico')}" />
        <title>Editar Procedimento Medico</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
        </div>
        <div class="body">
            <h1>Editar Procedimento Medico</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${procedimentoMedicoInstance}">
            	<div class="errors">
                	<g:renderErrors bean="${procedimentoMedicoInstance}" as="list" />
            	</div>
            </g:hasErrors>
            <g:each in="${procedimentoMedicoInstance.pagamento.prestacoes}" var="prestacao">
            	<g:hasErrors bean="${prestacao}">
            		<div class="errors">
                		<g:renderErrors bean="${prestacao}" as="list" />
            		</div>              
            	</g:hasErrors>
            </g:each>
            <g:form method="post" >
                <g:hiddenField name="id" value="${procedimentoMedicoInstance?.id}" />
                <g:hiddenField name="version" value="${procedimentoMedicoInstance?.version}" />
                <div class="dialog">
                    <table width="100%">
                        <tbody>
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="valor"><g:message code="procedimentoMedico.valor.label" default="Valor (*)" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: procedimentoMedicoInstance, field: 'valor', 'errors')}">
                                    <g:textField name="valor" value="${formatNumber(number : procedimentoMedicoInstance.valor)}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="tipo"><g:message code="procedimentoMedico.tipo.label" default="Tipo (*)" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: procedimentoMedicoInstance, field: 'tipo', 'errors')}">
                                    <g:select name="tipo.id" from="${core.TipoProcedimentoMedico.list()}" optionKey="id" value="${procedimentoMedicoInstance?.tipo?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="data"><g:message code="procedimentoMedico.data.label" default="Hor&aacute;rio (*)" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: procedimentoMedicoInstance, field: 'data', 'errors')}">
                                    <g:datePicker name="data" precision="minute" value="${procedimentoMedicoInstance?.data}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="informacoes"><g:message code="procedimentoMedico.informacoes.label" default="Informa&ccedil;&otilde;es" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: procedimentoMedicoInstance, field: 'informacoes', 'errors')}">
                                    <g:textArea name="informacoes" cols="40" rows="5" value="${procedimentoMedicoInstance?.informacoes}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="paciente"><g:message code="procedimentoMedico.paciente.label" default="Paciente (*)" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: procedimentoMedicoInstance, field: 'paciente', 'errors')}">
                                    <g:select name="paciente.id" from="${core.Paciente.list()}" optionKey="id" value="${procedimentoMedicoInstance?.paciente?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="medico"><g:message code="procedimentoMedico.medico.label" default="M&eacute;dico (*)" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: procedimentoMedicoInstance, field: 'medico', 'errors')}">
                                    <g:select name="medico.id" from="${core.Medico.list()}" optionKey="id" value="${procedimentoMedicoInstance?.medico?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <g:message code="NO-CODE" default="Pagamento (*)" />
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: procedimentoMedicoInstance, field: 'pagamento', 'errors')}">
                                	<table width=700>
                        				<tbody>
                                			<g:each in="${procedimentoMedicoInstance?.pagamento?.prestacoes}">
                                				<tr class="prop">
                                					<td width="15">
                                    					<g:message code="NO-CODE" default="${(it.posicao+1)}&ordm;" />
                                					</td>
                                					<td width=600 class="value ${hasErrors(bean: it, 'errors')}">
                                						Paga?
														&nbsp;<g:checkBox name="parcela_${it.id}_paga" value="${it.paga}"/>
                                						&nbsp;&nbsp;&nbsp;Data
                                						&nbsp;<g:datePicker name="parcela_${it.id}_data" precision="day" value="${it.dataDePagamento}"  />
                                						&nbsp;&nbsp;&nbsp;Valor
                                						&nbsp;<g:textField name="parcela_${it.id}_valor" value="${formatNumber(number : it.valor)}" />
                                					</td>
                            					</tr>
                                			</g:each>
                        				</tbody>
                                	</table>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                
                <g:message code="procedimentoMedico.observacoes" default="" />

			    <div class="buttons">
                    <span class="button"><g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
