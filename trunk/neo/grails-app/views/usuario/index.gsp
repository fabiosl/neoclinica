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
	        <h1>Configurações do sistema:</h1>
	        <br/>
			<h2>Navegue pelos serviços abaixo:</h2>
		</div>
		<div align="center">
			<neo:linhaDeBotoes>
				<neo:botao id="linkalterarsenha" link="usuario/alterarSenha" imgsrc="${resource(dir:'images/botoes',file:'senha.png')}" descricao="Alterar Senha"/>
            	<neo:botao id="linkusuario" link="usuario/list" imgsrc="${resource(dir:'images/botoes',file:'usuarios.png')}" descricao="Controle de Usuarios"/>
			</neo:linhaDeBotoes>
    	</div>
    </body>
</html>