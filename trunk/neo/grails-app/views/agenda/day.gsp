<%@ page contentType="text/html;charset=UTF-8"%>

<html>
<head>
<resource:calendarDayView />
<title>Agenda - Visualização do Dia</title>
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
	<div class="nav">
		<span class="menuButton"><a class="voltar" href="javascript:history.back()">Voltar</a></span>
			<span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
	</div>
	<br />
    <div align="center">
		<richui:calendarDayView startHour="7" endHour="19" date="${dataDia}" format="dd/MM/yyyy" items="${procs}" constraintDateFields="['data']" createLink="true" displayField="subject" teaser="true" teaserLength="100" action="show" controller="procedimentoMedico" />
	</div>
	<br/>
</body>
</html>