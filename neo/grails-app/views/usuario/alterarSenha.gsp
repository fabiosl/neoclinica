<%@ page contentType="text/html;charset=UTF-8" %>
<head>
	<meta name="layout" content="main" />
	<title>Alteração de Senha</title>
</head>
<body>
	<div class="nav">
		<span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
	</div>
	<div class="body">
		<h1>Alterar senha</h1>
		<g:if test="${flash.message}">
			<div class="message">${flash.message}</div>
			<br/>
		</g:if>
		<g:form>
			<div class="dialog">
				<table>
				<tbody>
					<tr class="prop">
						<td class="name"><label for="passwd">Senha atual:</label></td>
						<td><input type="password" id="oldPasswd" name="senhaAtual"/></td>
					</tr>
					<tr class="prop">
						<td class="name"><label for="passwd">Nova senha:</label></td>
						<td><input type="password" id="passwd" name="novaSenha"/></td>
					</tr>
				</tbody>
				</table>
			</div>
			<div class="buttons">
				<span class="button"><g:actionSubmit action="doAlterarSenha" class="save" value="Salvar" /></span>
			</div>
		</g:form>
	</div>
</body>
