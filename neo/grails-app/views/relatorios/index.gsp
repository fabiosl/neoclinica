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
	        <h1>Relatórios do sistema:</h1>
	        <br/>
			<h2>Navegue pelos serviços abaixo:</h2>
		</div>
		<div align="center">
			<neo:linhaDeBotoes>
				<neo:botao id="linkRelatoriosEstoque" link="estoque/relatorio" imgsrc="${resource(dir:'images/botoes',file:'relatorios.png')}" descricao="Relatorios do Estoque"/>
				<!--neo:botao id="linkRelaotriosFinanceiros" link="relatorios/financeiros" imgsrc="${resource(dir:'images/botoes',file:'relatorio.png')}" descricao="Relatorios Financeiros"/-->
            	<!--neo:botao id="linkRelatoriosEmail" link="relatorios/email" imgsrc="${resource(dir:'images/botoes',file:'relatorioEmail.png')}" descricao="Envio de Relatorios por Email"/-->
			</neo:linhaDeBotoes>
    	</div>
    </body>
</html>