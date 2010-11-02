<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <title>SI Neo</title>
		<meta name="layout" content="main_sem_table" />
        <link rel="stylesheet" href="${resource(dir:'css',file:'main_sem_table.css')}" />
        <g:javascript src="jquery.js" />
        <g:javascript src="jquery.maskedinput.js" />
    </head>
    <body>
    	 <g:javascript>
        jQuery(function($){
          $.mask.definitions['A']='[A-Z]';
          $("#dateStart").mask("9999-99-99");
          $("#dateEnd").mask("9999-99-99");
        });
		 </g:javascript>

    
		<div class="nav">
			<span class="menuButton"><a class="voltar" href="javascript:history.back()">Voltar</a></span>
			<span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
		</div>
		<div id="pageBody" class="dialog">
	        <h1>Relatórios de Estoque:</h1>
	        <br/>
		</div>
		<div align="center">
            <g:jasperReport jasper="transacoesEstoque" format="PDF" name="Relatório"> 
			
<br></br>
			
			<p> Data Inicial (AAAA-MM-DD): 
			<input name="dateStart" id="dateStart" precision="day" />
			</p>
			<p> Data Final (AAAA-MM-DD):   
            <input name="dateEnd" id="dateEnd" precision="day" />
            </p>
            </td>
            
            </g:jasperReport>
    	</div>
    </body>
</html>