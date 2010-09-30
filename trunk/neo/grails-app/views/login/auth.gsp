<%@ page contentType="text/html;charset=UTF-8" %>
<head>
<meta name='layout' content='main' />
<title>SI Neo</title>
<style type='text/css' media='screen'>
#login {
	margin:15px 0px; padding:0px;
	text-align:center;
}
#login .inner {
	width:300px;
	margin:0px auto;
	text-align:left;
	padding:10px;
	border-top:1px solid green;
	border-bottom:1px solid green;
	background-color:white;
}
#login .inner .fheader {
	padding:4px;margin:3px 0px 3px 0;color:#2e3741;font-size:14px;font-weight:bold;
}
#login .inner .cssform p {
	clear: left;
	margin: 0;
	padding: 5px 0 8px 0;
	padding-left: 105px;
	border-top: 1px dotted gray;
	margin-bottom: 10px;
	height: 1%;
}
#login .inner .cssform input[type='text'] {
	width: 180px;
}
#login .inner .cssform label {
	font-weight: bold;
	float: left;
	margin-left: -105px;
	width: 100px;
}
#login .inner .login_message {color:red;}
#login .inner .text_ {width:180px;}
#login .inner .chk {height:12px;}
</style>
</head>

<body>
	<div class="nav">
		<span class="menuButton"><a href="/sobre.gsp" class="info">Sobre</a></span>
	</div>
	<g:if test="${flash.message}">
		<br/><div class="message">${flash.message}</div><br/>
	</g:if>
	<div id='login'>
		<div class='inner'>
			<div class='fheader'>Digite login e senha</div>
			<br/>
			<form action='${postUrl}' method='POST' id='loginForm' class='cssform'>
				<p>
					<label for='j_username'>Login</label>
					<input type='text' class='text_' name='j_username' id='j_username' value='${request.remoteUser}' />
				</p>
				<p>
					<label for='j_password'>Senha</label>
					<input type='password' class='text_' name='j_password' id='j_password' />
				</p>
				<p>
					<input type='submit' value='OK' />
				</p>
			</form>
		</div>
	</div>
<script type='text/javascript'>
<!--
(function(){
	document.forms['loginForm'].elements['j_username'].focus();
})();
// -->
</script>
</body>
