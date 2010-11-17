<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<title>SI Neo</title>
<meta name="layout" content="main_sem_table" />
<link rel="stylesheet"
	href="${resource(dir:'css',file:'main_sem_table.css')}" />
</head>
<body>
<div class="nav"><span class="menuButton"><a class="voltar"
	href="javascript:history.back()">Voltar</a></span> <span class="menuButton"><a
	class="home" href="${createLinkTo(dir:'')}">Home</a></span></div>
<div id="pageBody" class="dialog">
<h1>Relatórios de Finanças:</h1>
<h2>Navegue pelas opções abaixo</h2>
<br />
</div>
<div align="center"><neo:linhaDeBotoes>
	<neo:botao id="linkRelatoriosFinanceirosData" link="relatorioFinancaData.gsp"
		imgsrc="${resource(dir:'images/botoes',file:'relatorioData.png')}"
		descricao="Relat&oacute;rio de Transações (por data)" />
	<neo:botao id="linkRelatoriosAtual"
		link="${createLinkTo(dir:'/jasper/?_format=PDF&_file=relatorioLentes')}"
		imgsrc="${resource(dir:'images/botoes',file:'caixa.png')}"
		descricao="Relat&oacute;rio do Dia" />
</neo:linhaDeBotoes></div>
</body>
</html>