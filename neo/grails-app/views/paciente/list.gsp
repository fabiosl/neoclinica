<%@ page import="core.Paciente" %>
<html>
    <head>
    	<g:javascript library="prototype" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'paciente.label', default: 'Paciente')}" />
        <title>Busca de Pacientes</title>
    </head>
    <body>
   		<parameter name="foo" value="bar" />
        <div class="nav">
        	<span class="menuButton"><a class="voltar" href="javascript:history.back()">Voltar</a></span>
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
        </div>
        <div class="body">
            <h1>Busca de Pacientes</h1>
            <g:if test="${flash.message}">
            	<div class="message">${flash.message}</div>
            </g:if>
			<br/>
			<g:formRemote name="formBusca" url="[action : 'search']" update="resultadoDeBusca"
			   onFailure="alert('Algo deu errado ao executar sua consulta');">
				Nome  <g:textField name="nome" id="nome" />
				<g:submitButton name="Buscar"/>
			</g:formRemote>
			
			<br/>
			<div id="resultadoDeBusca">
				<g:if test="${pacienteInstanceList != null}">
					<g:render template="/common/listaPacientes" model="['pacienteInstanceList' : pacienteInstanceList, 'nomeBuscado' : nomeBuscado]" />
				</g:if>
			</div>
        </div>
    </body>
</html>
