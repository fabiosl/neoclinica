<%@ page contentType="text/html;charset=UTF-8" %>
<head>
</head>
<div align="center">
	<!-- USAR TAG ifrole QUE FOI CRIADA NA NeoTagLib PRA RESTRINGIR BOTOES AOS PAPEIS -->
    <neo:linhaDeBotoes>
       <!-- neo:botao link="" imgsrc="${resource(dir:'images/botoes',file:'busca.png')}" descricao="Busca de Pacientes"/ -->
       <neo:botao id="linkagenda" link="paciente" imgsrc="${resource(dir:'images/botoes',file:'calendario.png')}" descricao="Agenda M\u00E9dica"/>
       <neo:botao id="linkpaciente" link="paciente" imgsrc="${resource(dir:'images/botoes',file:'paciente.png')}" descricao="Controle de Pacientes"/>
       <neo:botao id="linklentes" link="lente" imgsrc="${resource(dir:'images/botoes',file:'lentes.png')}" descricao="Controle de Lentes"/>
       <neo:botao id="linkopcoes" link="paciente" imgsrc="${resource(dir:'images/botoes',file:'opcoes.png')}" descricao="Op\u00e7\u00f5es"/>
       
       <!-- neo:botao id="linkalterarsenha" link="usuario/alterarSenha" imgsrc="${resource(dir:'images/botoes',file:'senha.png')}" descricao="Alterar Senha"/ -->
       <!-- neo:botao id="linkusuario" link="usuario" imgsrc="${resource(dir:'images/botoes',file:'usuarios.png')}" descricao="Controle de Usuarios"/ -->

    </neo:linhaDeBotoes>
    <neo:linhaDeBotoes>
       <!--neo:botao link="fornecedor" imgsrc="${resource(dir:'images/botoes',file:'fornecedor.png')}" descricao="Controle de Fornecedores"/ -->
       <!--neo:botao link="lente" imgsrc="${resource(dir:'images/botoes',file:'lentes.png')}" descricao="Controle de Estoque"/ -->
       <!-- neo:botao link="" imgsrc="${resource(dir:'images/botoes',file:'financas.png')}" descricao="Controle Financeiro"/ -->
       <!-- neo:botao link="" imgsrc="${resource(dir:'images/botoes',file:'calendario.png')}" descricao="Agenda"/ -->
    </neo:linhaDeBotoes>
</div>
