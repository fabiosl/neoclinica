<html>
    <head>
        <title><g:layoutTitle default="Grails" /></title>
        <link rel="stylesheet" href="${resource(dir:'css',file:'main.css')}" />
        <link rel="shortcut icon" href="${resource(dir:'images',file:'icnDoctor.ico')}" type="image/x-icon" />
        <g:layoutHead />
        <g:javascript library="application" />
    </head>
    <body>
        <div id="spinner" class="spinner" style="display:none;">
            <img src="${resource(dir:'images',file:'spinner.gif')}" alt="Spinner" />
        </div>
        <div id="grailsLogo" class="logo"><img src="${resource(dir:'images',file:'grails_logo.png')}" alt="Grails" border="0" /></div>
        <g:layoutBody />
        <br/><br/>
        <div id="footer">
        	<g:render template="/common/footer" />
        </div>
    </body>
</html>