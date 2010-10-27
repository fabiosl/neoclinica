<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <title>SI Neo</title>
		<meta name="layout" content="main_sem_table" />
        <link rel="stylesheet" href="${resource(dir:'css',file:'main_sem_table.css')}" />
    </head>
    <body>
		<div class="nav">
			<span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
		</div>
		<div id="pageBody" class="dialog">
	        <h1>Controle de Procedimentos:</h1>
	        <br/>
			<h2>Navegue pelos serviços abaixo:</h2>
		</div>
		<div align="center">
			<neo:linhaDeBotoes>
			<neo:botao id="linkprocedimentos" link="procedimentos/create" imgsrc="${resource(dir:'images/botoes',file:'addProcedimento.png')}" descricao="Cadastrar Novo Procedimento Medico"/>
			<neo:botao id="linkexames" link="exames/create" imgsrc="${resource(dir:'images/botoes',file:'procedimentoPaciente.png')}" descricao="Cadastrar Procedimento para Paciente"/>
			</neo:linhaDeBotoes>
    	</div>
    </body>
</html>