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
	        <h1>Controle de Pacientes:</h1>
	        <br/>
			<h2>Navegue pelos serviços abaixo:</h2>
		</div>
		<div align="center">
			<neo:linhaDeBotoes>
				<neo:botao id="linkadicionarpaciente" link="paciente/create" imgsrc="${resource(dir:'images/botoes',file:'adicionarUsuario.png')}" descricao="Adicionar Paciente"/>
            	<neo:botao id="linkconvenio" link="convenio" imgsrc="${resource(dir:'images/botoes',file:'unimed.png')}" descricao="Controle de Convenios"/>
				<neo:botao id="linkbuscarpacientes" link="paciente/list" imgsrc="${resource(dir:'images/botoes',file:'busca.png')}" descricao="Buscar Pacientes"/>
			</neo:linhaDeBotoes>
    	</div>
    </body>
</html>