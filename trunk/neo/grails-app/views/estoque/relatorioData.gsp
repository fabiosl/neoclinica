<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <title>SI Neo</title>
		<meta name="layout" content="main_sem_table" />
        <link rel="stylesheet" href="${resource(dir:'css',file:'main_sem_table.css')}" />
    </head>
    <body>
		<div class="nav">
			<span class="menuButton"><a class="voltar" href="javascript:history.back()">Voltar</a></span>
			<span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
		</div>
		<div id="pageBody" class="dialog">
	        <h1>Relatórios de Estoque:</h1>
	        <br/>
		</div>
		<div align="center">
			<g:form action="escolher">
				<legend>Escolher a data do relatório</legend>
				<div align="center">
				<resource:dateChooser />
				<g:form>
	    			<richui:dateChooser name="dataRelatorio" format="dd.MM.yyyy" locale="pt_BR" />
				</g:form>
				</div>
				<g:submitButton name="submit" value="Avancar" />
			</g:form>
    	</div>
    </body>
</html>