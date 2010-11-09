<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <title>SI Neo</title>
		<meta name="layout" content="main_sem_table" />
        <link rel="stylesheet" href="${resource(dir:'css',file:'main_sem_table.css')}" />
        <g:javascript src="jquery.js" />
        <g:javascript src="jquery.maskedinput.js" />
    </head>
    <body>
		<div class="nav">
			<span class="menuButton"><a class="voltar" href="javascript:history.back()">Voltar</a></span>
			<span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
		</div>
		<div id="pageBody" class="dialog">
	        <h1>Relatório de Transações (por Data)</h1>
	        <br/>
		</div>
		<g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
	        <br/>
        </g:if>
		<div align="center">
			<g:form id="report" name="report" controller="relatorios" action="relatorioDeTransacoesPorData">
				<p>Data Inicial:
					<g:datePicker name="dateStart" id="dateStart" precision="day" />
				</p>
				<p>Data Final:   
					<g:datePicker name="dateEnd" id="dateEnd" precision="day" />
            	</p>
            	<br/><br/>
            	<span class="menuButton"><a class="pdf" href="javascript:void(0);" onclick="document.report.submit();return false;">Download</a></span>
			</g:form>
    	</div>
    </body>
</html>