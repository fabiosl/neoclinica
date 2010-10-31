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
	        <h1>Relatórios de Estoque:</h1>
	        <h2>Navegue pelas opções abaixo</h2>
	        <br/>
		</div>
		<div align="center">
			<neo:linhaDeBotoes>
				<neo:botao id="linkRelatoriosEstoqueData" link="relatorioData" imgsrc="${resource(dir:'images/botoes',file:'relatorioData.png')}" descricao="Relatorios de uma data especifica"/>
				<neo:botao id="linkRelatoriosHoje" link="relatorioHoje" imgsrc="${resource(dir:'images/botoes',file:'relatorioHoje.png')}" descricao="Relatorios do dia atual"/>
			</neo:linhaDeBotoes>
    	</div>
    </body>
</html>