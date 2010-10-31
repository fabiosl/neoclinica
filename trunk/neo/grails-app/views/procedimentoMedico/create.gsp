
<%@ page import="core.ProcedimentoMedico" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'procedimentoMedico.label', default: 'ProcedimentoMedico')}" />
        <title>Criar Procedimento Medico</title>
    </head>
    <body>
        <div class="nav">
        	<span class="menuButton"><a class="voltar" href="javascript:history.back()">Voltar</a></span>
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
        </div>
        <div class="body">
            <h1>Marcar Procedimento Medico</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${procedimentoMedicoInstance}">
            <div class="errors">
                <g:renderErrors bean="${procedimentoMedicoInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:hasErrors bean="${procedimentoMedicoInstance.pagamento}">
            <div class="errors">
                <g:renderErrors bean="${procedimentoMedicoInstance.pagamento}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <table>
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
                                	<g:if test="${pacientePreDefinido == null}">
                                		<g:select name="paciente.id" from="${core.Paciente.list()}" optionKey="id" value="${procedimentoMedicoInstance?.paciente?.id}"  />
                                	</g:if>
                                	<g:else>
                                		<g:select name="paciente.id" from="${core.Paciente.list()}" optionKey="id" value="${pacientePreDefinido?.id}" />
                                	</g:else>
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
                                    <g:message code="NO-CODE" default="Quantidade de Parcelas (*)" />
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: procedimentoMedicoInstance.pagamento, field: 'pagamento', 'errors')}">
                                    <g:select name="quantidadeDeParcelas" from="${2..24}" noSelection="[ 1 : 'A Vista']"/>
                                </td>
                            </tr>
                            
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <g:message code="NO-CODE" default="Forma de Pagamento (*)" />
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: procedimentoMedicoInstance.pagamento, field: 'formaDePagamento', 'errors')}">
                                    <g:select name="formaDePagamento" from="${core.FormaDePagamento?.values()}" value="${procedimentoMedicoInstance?.pagamento?.formaDePagamento}"  />
                                </td>
                            </tr>
                            
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <g:message code="NO-CODE" default="Cart&atilde;o" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: procedimentoMedicoInstance.pagamento, field: 'formaDePagamento', 'errors')}">
                                    <g:textField name="cartao" value="${fieldValue(bean: procedimentoMedicoInstance.pagamento, field: 'cartao')}" />
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                
                <g:message code="procedimentoMedico.observacoes" default="" />
                
                <div class="buttons">
                    <span class="button"><g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
