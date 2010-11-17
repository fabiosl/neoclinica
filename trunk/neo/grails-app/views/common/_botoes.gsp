<%@ page contentType="text/html;charset=UTF-8" %>
<head>
</head>
<div align="center">
	<!-- USAR TAG ifrole QUE FOI CRIADA NA NeoTagLib PRA RESTRINGIR BOTOES AOS PAPEIS -->
    <neo:linhaDeBotoes>
       <neo:botao id="linkpaciente" link="paciente" imgsrc="${resource(dir:'images/botoes',file:'paciente.png')}" descricao="Cadastro de Pacientes"/>
       <neo:botao id="linkestoque" link="estoque" imgsrc="${resource(dir:'images/botoes',file:'estoque.png')}" descricao="Controle de Estoque"/>
       <neo:botao id="linkProcedimento" link="procedimentoMedico" imgsrc="${resource(dir:'images/botoes',file:'procedimento.png')}" descricao="Procedimentos M\u00E9dicos"/>
       <neo:botao id="linkmedicos" link="medico" imgsrc="${resource(dir:'images/botoes',file:'adicionarMedico.png')}" descricao="Cadastro de M\u00E9dicos"/>
    </neo:linhaDeBotoes>
    <neo:linhaDeBotoes>
       <neo:botao id="linkRelatorios" link="relatorios" imgsrc="${resource(dir:'images/botoes',file:'financas.png')}" descricao="Relat&oacute;rios"/>
       <neo:botao id="linkAgenda" link="agenda" imgsrc="${resource(dir:'images/botoes',file:'agenda.png')}" descricao="Agenda M\u00E9dica"/>
       <neo:botao id="linkopcoes" link="usuario" imgsrc="${resource(dir:'images/botoes',file:'opcoes.png')}" descricao="Configura\u00e7\u00f5es"/>
    </neo:linhaDeBotoes>
</div>
