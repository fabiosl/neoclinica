<%@ page contentType="text/html;charset=UTF-8"%>

<html>
<head>
<resource:calendarWeekView />
<title>Visualização de Consultas Semanais</title>
<meta name="layout" content="main" />
<style type="text/css" media="screen">
.homePagePanel .panelBody ul {
	list-style-type: none;
	margin-bottom: 15px;
}

.homePagePanel .panelBody h1 {
	text-transform: uppercase;
	font-size: 1.1em;
	margin-bottom: 10px;
}

h2 {
	margin-top: 15px;
	margin-bottom: 15px;
	font-size: 1.2em;
}

#pageBody {
	margin-left: 120px;
	margin-right: 20px;
}
</style>
</head>
<body>
	<br />
    <div align="center">
   		<g:form action="inicio">
			<richui:calendarWeekView startHour="07" endHour="19" date="${data}" format="dd.MM.yyyy" items="${tudo}" constraintDateFields="['data']" createLink="true" displayField="toString()" teaser="false" teaserLength="20" controller="procedimentoMedico" action="show" dayAction="day" />
			<br/><g:submitButton name="submit" value="Voltar"/>
    	</g:form>
	</div>
	<br/>
</body>
</html>