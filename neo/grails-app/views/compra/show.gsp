
<%@ page import="core.Compra" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'compra.label', default: 'Compra')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
        	<span class="menuButton"><a class="voltar" href="javascript:history.back()">Voltar</a></span>
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
       		<g:if test="${compraInstance.paciente != null}">
       			<span class="menuButton"><g:link class="list_proc" action="list" params="[idPaciente : compraInstance?.paciente?.id]">Listar compras de ${compraInstance?.paciente}</g:link></span>
       		</g:if>
       		<g:if test="${compraInstance.dataRecebimento == null}">
        		<span class="menuButton"><g:link class="confirmar" action="confirmarEntregaCompra" params="[id : compraInstance?.id]" onclick="return confirm('Deseja realmente confirmar a compra?');" >Confirmar entrega</g:link></span>
   			</g:if>
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
                            <td valign="top" class="name"><g:message code="compra.id.label" default="Id" /></td>
                            <td valign="top" class="value">${fieldValue(bean: compraInstance, field: "id")}</td>
                       </tr>
                       <tr class="prop">
                            <td valign="top" class="name"><g:message code="compra.valor.label" default="Valor" /></td>
                            <td valign="top" class="value">${formatNumber(number : fieldValue(bean: compraInstance, field: "valor"))}</td>
                       </tr>
                       <tr class="prop">
                            <td valign="top" class="name"><g:message code="compra.dataPedido.label" default="Data do Pedido" /></td>
                            <td valign="top" class="value"><g:formatDate format="dd/MM/yyyy" date="${compraInstance?.dataPedido}" /></td>
                       </tr>
                       <tr class="prop">
                            <td valign="top" class="name"><g:message code="compra.paciente.label" default="Paciente" /></td>
                            <td valign="top" class="value"><g:link controller="paciente" action="show" id="${compraInstance?.paciente?.id}">${compraInstance?.paciente?.encodeAsHTML()}</g:link></td>
                       </tr>
                       <tr class="prop">
                       		<td valign="top" class="name">Situa&ccedil;&atilde;o de Entrega</td>
                            <td valign="top" class="value">${compraInstance?.statusDeEntrega()}</td>
                       </tr>
                       <g:if test="${compraInstance.dataRecebimento != null}">
                       		<tr class="prop">
                            	<td valign="top" class="name"><g:message code="compra.dataRecebimento.label" default="Data de Entrega" /></td>
                            	<td valign="top" class="value"><g:formatDate format="dd/MM/yyyy" date="${compraInstance?.dataRecebimento}" /></td>
                       		</tr>
                       </g:if>
                       <tr class="prop">
                          	<td valign="top" class="name"><g:message code="compra.dataRecebimento.label" default="Itens" /></td>
                          	 <td valign="top" class="value">
                                <table>
                    				<tbody>
                       					<tr class="prop">
                            				<td width="100"><i>Lente</i></td>
                            				<td width="100"><i>Quantidade</i></td>
                            				<td width="100"><i>Valor do Item</i></td>
                       					</tr>
                       					<g:each in="${compraInstance?.itens?}" var="item">
                            					<tr class="prop">
                            						<td><g:link controller="lente" action="show" id="${item.lente?.id}">${item.lente?.tipo}</g:link></td>
                            						<td>${item.quantidadeComprada}</td>
                            						<td>${formatNumber(number : item.valorTotal())}</td>
                       							</tr>
                            			</g:each>
                    				</tbody>
                				</table>
                            </td>
                       </tr>
                       <tr class="prop">
                            <td valign="top" class="name"><g:message code="compra.medico.label" default="Pagamento" /></td>
                            <td valign="top" class="value">
                                <table>
                    				<tbody>
                       					<tr class="prop">
                            				<td width="150"><i>${compraInstance?.pagamento?.formaDePagamento()}</i></td>
                            				<td width="100"><i>Pago</i></td>
                            				<td width="150"><i>Data de Pagamento</i></td>
                            				<td width="100"><i>Valor</i></td>
                       					</tr>
                       					<g:each in="${compraInstance?.pagamento?.prestacoes}">
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
                    <g:hiddenField name="id" value="${compraInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" action="edit" value="${message(code: 'default.button.edit.label', default: 'Edit')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
