package core

class Compra extends Procedimento{
	Date dataPedido
	Date dataRecebimento
	
	static constraints = {
		dataPedido(nullable:false)
	}
}
