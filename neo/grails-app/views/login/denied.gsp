<%@ page contentType="text/html;charset=UTF-8" %>
<html>
	<head>
		<title>Não autorizado</title>
		<meta name="layout" content="main" />
	</head>
	<body>
		<div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}">Home</a></span>
        </div>
		<div id="pageBody">
        <br/>
		<div class="erroSedare">Desculpe, você possui nível de acesso insuficiente para acessar essa página.</div>
		<br/>
		</div>
		<div align="center">
        	<input type=button value="Voltar" onClick="history.go(-1)">
        </div>
	</body>
</html>