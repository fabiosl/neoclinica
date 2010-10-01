<%@ page contentType="text/html;charset=UTF-8" %>
<head>
</head>
<div align="center">
	<!-- USAR TAG ifrole QUE FOI CRIADA NA NeoTagLib PRA RESTRINGIR BOTOES AOS PAPEIS -->
    <neo:linhaDeBotoes>
       <neo:botao id="linkagenda" link="" imgsrc="${resource(dir:'images/botoes',file:'calendario.png')}" descricao="Agenda M\u00E9dica"/>
       <neo:botao id="linkpaciente" link="paciente" imgsrc="${resource(dir:'images/botoes',file:'paciente.png')}" descricao="Controle de Pacientes"/>
       <neo:botao id="linklentes" link="lente" imgsrc="${resource(dir:'images/botoes',file:'lentes.png')}" descricao="Controle de Lentes"/>
       <neo:botao id="linkopcoes" link="configuracoes.gsp" imgsrc="${resource(dir:'images/botoes',file:'opcoes.png')}" descricao="Configura\u00e7\u00f5es"/>
    </neo:linhaDeBotoes>
    <!-- neo:botao link="fornecedor" imgsrc="${resource(dir:'images/botoes',file:'fornecedor.png')}" descricao="Controle de Fornecedores"/ -->
    <!-- neo:botao link="" imgsrc="${resource(dir:'images/botoes',file:'financas.png')}" descricao="Controle Financeiro"/ -->
</div>
