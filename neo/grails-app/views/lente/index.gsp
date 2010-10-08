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
				<neo:botao id="linkListarLentes" link="lente/list" imgsrc="${resource(dir:'images/botoes',file:'listarLentes.png')}" descricao="Listar Lentes"/>
				<neo:botao id="linkAdicionarLente" link="lente/create" imgsrc="${resource(dir:'images/botoes',file:'adicionarLente.png')}" descricao="Adicionar Lente"/>
            	<neo:botao id="linkconvenio" link="fornecedor" imgsrc="${resource(dir:'images/botoes',file:'adicionarFornecedor.png')}" descricao="Controle Fornecedores"/>
            	<neo:botao id="linkconvenio" link="fornecimento" imgsrc="${resource(dir:'images/botoes',file:'fornecimento.png')}" descricao="Cadastrar Recebimento Mercadorias"/>
			</neo:linhaDeBotoes>
    	</div>
    </body>
</html>