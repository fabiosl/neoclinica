<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <title>SI Neo</title>
		<meta name="layout" content="main_sem_table" />
        <link rel="stylesheet" href="${resource(dir:'css',file:'main_sem_table.css')}" />
    </head>
    <body>
		<div class="nav">
		    <span class="menuButton"><g:link controller="logout" class="login">Logout</g:link></span>
		</div>
		<div id="pageBody" class="dialog">
	        <h1>Olá, ${loggedInUserInfo(field:'userRealName')}, bem vindo ao SI Neo!</h1>
	        <br/>
			<h2>Navegue pelos serviços abaixo:</h2>
		</div>
        <g:render template="/common/botoes" />
    </body>
</html>