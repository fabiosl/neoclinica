<%@ page contentType="text/html;charset=UTF-8" %>
<html>
	<head>
		<title>Não autorizado</title>
		<meta name="layout" content="main" />
		<style type="text/css" media="screen">
			#pageBody {
				margin-left:20px;
				margin-right:20px;
			}
		</style>
	</head>
	<body>
		<g:redirectIfNotLogged />
		<div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}">Home</a></span>
        </div>
        <br/>
		<div class="erroSedare">Você não possui nível de acesso suficiente para acessar essa página.</div>
		<br/>
		<div id="pageBody">
			<ul>
        		<input type=button value="Voltar" onClick="history.go(-1)">
			</ul>
		</div>
	</body>
</html>