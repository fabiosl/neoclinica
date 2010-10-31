<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
	  <meta name="layout" content="main" />
	  <title>SI Neo - Erro</title>
  </head>
  <body>
	<div class="nav">
		<span class="menuButton"><a class="voltar" href="javascript:history.back()">Voltar</a></span>
		<span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
	</div>
	<div class="body">
    	<h1>Ocorreu um erro!</h1>
    	<h2>Favor enviar os dados abaixo para a equipe tecnica.</h2>
			<strong>Error ${request.'javax.servlet.error.status_code'}:</strong> ${request.'javax.servlet.error.message'.encodeAsHTML()}<br/>
			<strong>Servlet:</strong> ${request.'javax.servlet.error.servlet_name'}<br/>
			<strong>URI:</strong> ${request.'javax.servlet.error.request_uri'}<br/>
			<g:if test="${exception}">
	  			<strong>Exception Message:</strong> ${exception.message?.encodeAsHTML()} <br />
	  			<strong>Caused by:</strong> ${exception.cause?.message?.encodeAsHTML()} <br />
	  			<strong>Class:</strong> ${exception.className} <br />
	  			<strong>At Line:</strong> [${exception.lineNumber}] <br />
	  			<strong>Code Snippet:</strong><br />
	  			<div class="snippet">
	  				<g:each var="cs" in="${exception.codeSnippet}">
	  					${cs?.encodeAsHTML()}<br />
	  				</g:each>
	  			</div>
			</g:if>
	<g:if test="${exception}">
	    <h2>Stack Trace</h2>
	    <div class="stack">
	      <pre><g:each in="${exception.stackTraceLines}">${it.encodeAsHTML()}<br/></g:each></pre>
	    </div>
	</g:if>
  	</div>
  </body>
</html>