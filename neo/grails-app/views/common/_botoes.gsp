<%@ page contentType="text/html;charset=UTF-8" %>
<head>
</head>
<div align="center">
	<!-- USAR TAG ifrole QUE FOI CRIADA NA NeoTagLib PRA RESTRINGIR BOTOES AOS PAPEIS -->
    <neo:linhaDeBotoes>
       <!--  neo:botao link="" imgsrc="${resource(dir:'images/botoes',file:'busca.png')}" descricao="Busca de Pacientes"/ -->
       <neo:botao link="paciente" imgsrc="${resource(dir:'images/botoes',file:'paciente.png')}" descricao="Controle de Pacientes"/>
       <!--  neo:botao link="" imgsrc="${resource(dir:'images/botoes',file:'financas.png')}" descricao="Controle Financeiro"/ -->
       <neo:botao link="lente" imgsrc="${resource(dir:'images/botoes',file:'lentes.png')}" descricao="Controle de Estoque"/>
       <neo:botao link="fornecedor" imgsrc="${resource(dir:'images/botoes',file:'fornecedor.png')}" descricao="Controle de Fornecedores"/>
    </neo:linhaDeBotoes>
    <neo:linhaDeBotoes>
       <neo:botao link="usuario" imgsrc="${resource(dir:'images/botoes',file:'usuarios.png')}" descricao="Controle de Usuarios"/>
       <!-- neo:botao link="" imgsrc="${resource(dir:'images/botoes',file:'calendario.png')}" descricao="Agenda"/ -->
       <!-- neo:botao link="" imgsrc="${resource(dir:'images/botoes',file:'senha.png')}" descricao="Alterar Senha"/ -->
    </neo:linhaDeBotoes>
</div>
