class NeoTagLib {
	static namespace = 'neo'
	
	def copyright = {
		out << """
				&copy; ${Calendar.getInstance().get(Calendar.YEAR)} SI Neo
				<br/> 
				Fabio Leal, Renato Almeida, Solon Aguiar
				"""
	}
	
	def redirectMainPage = {
		response.sendRedirect("/login/auth")
	}
	
	def ifrole = { attrs, body ->
		out << '<g:ifAllGranted role=' + attrs['roles'] + '>'
		out << body()
		out << '</g:ifAllGranted>'
	}
	
	def linhaDeBotoes = { attrs, body ->
		out << '<table align="center" cellpadding="2" cellspacing="2" border="0">'
		out << '<tr>'
		out << body()
		out << '</tr>'
		out << '</table>'
	}
	
	def botao = { attrs ->
		out << '<td align="center">'
		out << '<table cellpadding="4" cellspacing="4" border="0">'
		out << '<tr>'
		out << '<td>'
		out << '<div align="center">'
		out << '<a href="' + attrs["link"] + '"><img src="' + attrs["imgsrc"] + '" border="0"></a>'
		out << '</div>'
		out << '</td>'
		out << '</tr>'
		out << '<tr>'
		out << '<td>'
		out << '<div align="center">'
		out << '<font size="1">' + attrs["descricao"] + '</font>'
		out << '</div>'
		out << '</td>'
		out << '</tr>'
		out << '</table>'
		out << '</td>'
	}
}
