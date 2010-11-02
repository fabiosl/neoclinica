<%@ page import="core.Compra" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'compra.label', default: 'Compra')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
		<g:javascript src="neo.js" />
    </head>
    <body>
    
<% 
   def todasAsLentes = core.Lente.list()
   def listaDeIdsDeLentes = []
   def listaDeValoresDeLente = ""
   def separador = ""
   todasAsLentes.each {
   		listaDeIdsDeLentes.add(it.id);
   		listaDeValoresDeLente = listaDeValoresDeLente + (separador + it.descricao());
   		separador = "#";
} %>
    
        <div class="nav">
           	<span class="menuButton"><a class="voltar" href="javascript:history.back()">Voltar</a></span>
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
        </div>
        <div class="body">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${compraInstance}">
            	<div class="errors">
                	<g:renderErrors bean="${compraInstance}" as="list" />
            	</div>
            </g:hasErrors>
            <g:each in="${compraInstance?.pagamento?.prestacoes}" var="prestacao">
            	<g:hasErrors bean="${prestacao}">
            		<div class="errors">
                		<g:renderErrors bean="${prestacao}" as="list" />
            		</div>              
            	</g:hasErrors>
            </g:each>
            <g:form method="post" >
                <g:hiddenField name="id" value="${compraInstance?.id}" />
                <g:hiddenField name="version" value="${compraInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="dataPedido"><g:message code="compra.dataPedido.label" default="Data do Pedido (*)" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: compraInstance, field: 'dataPedido', 'errors')}">
                                    <g:datePicker name="dataPedido" precision="day" value="${compraInstance?.dataPedido}"  />
                                </td>
                            </tr>
                            <g:if test="${compraInstance.dataRecebimento == null}">
              				<tr class="prop">
								<td valign="top" class="name"><g:message code="NO-CODE"
												default="Itens" />
									<span class="menuButton"><a	class="add" onclick="addItem('area_itens', ${listaDeIdsDeLentes}, '${listaDeValoresDeLente}')"}"></a></span>
								</td>
								<td valign="top">
									<table id="area_itens">
										<g:each in="${compraInstance?.itens}" var="itemDeVenda" status="i">
											<tr>
												<td class="value ${hasErrors(bean: itemDeVenda, 'errors')}">
													Lente  <g:select id="item_select_${-i}" name="item_select_${-i}" from="${todasAsLentes}" optionKey="id" optionValue="${{it.descricao()}}" value="${itemDeVenda.lente.id}" />
									   				Quantidade   <input id="item_input_${-i}" name="item_input_${-i}" type="text" value="${itemDeVenda?.quantidadeComprada}" />
									   				<span class="menuButton"><a class="delete" onClick="this.parentNode.parentNode.parentNode.removeChild(this.parentNode.parentNode);"></a></span>
												</td>
											</tr>
										</g:each>
									</table>
								</td>
							</tr>
							</g:if>
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <g:message code="NO-CODE" default="Pagamento (*)" />
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: compraInstance, field: 'pagamento', 'errors')}">
                                	<table width=700>
                        				<tbody>
                                			<g:each in="${compraInstance?.pagamento?.prestacoes}">
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
			    <div class="buttons">
                    <span class="button"><g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
