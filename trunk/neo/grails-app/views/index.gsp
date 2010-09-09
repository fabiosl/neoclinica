<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <title>SI Neo</title>
		<meta name="layout" content="main" />
    </head>
    <body>
		<div class="nav">
		    <span class="menuButton"><g:link class="login">Logout</g:link></span>
		</div>
		<div id="pageBody">
	        <h1>Bem vindo ao SI Neo!</h1>
	        <br/>
	        <div id="controllerList" class="dialog">
				<h2>Serviços disponíveis:</h2>
	            <ul>
	              <g:each var="c" in="${grailsApplication.controllerClasses}">
	                    <li class="controller"><g:link controller="${c.logicalPropertyName}">Controle de ${c.logicalPropertyName}</g:link></li>
	              </g:each>
	            </ul>
	        </div>
		</div>
    </body>
</html>