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
	        <h1>Agenda dos Médicos</h1>
	        <br/>
		</div>
		<div align="center">
		<g:form action="escolherMedico">
	    	<fieldset>
	    	 	<legend>Escolha o médico</legend>
				<g:select name="medico" from="${core.Medico.list()}" />
				<div align="center">
				<g:submitButton name="submit" value="Avançar" />
				</div>
	    	</fieldset>
		 </g:form>
		 </div>
    </body>
</html>