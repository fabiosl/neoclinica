package services;

import core.Lente;
import java.util.HashMap;
import core.Fornecimento 
import core.ItemDeVenda;
import core.Compra 
import core.TransacaoEstoque;
import core.TransacaoKind;

class TransacoesService {
	boolean transactional = true
	
	def authenticateService /* Acegi */
	
	def confirmarFornecimento(Fornecimento fornecimento) {
		if (fornecimento.getDataRecebimento() != null) {
			throw new TransacaoEstoqueException("Fornecimento ja confirmado!");
		}
		
		Date dataAtual = new Date();
		
		def lente = fornecimento.getLente();
		lente.setQuantidade(lente.getQuantidade() + fornecimento.getQuantidade());
		
		def logInfo = new TransacaoEstoque(lente, dataAtual, TransacaoKind.CHEGADA, authenticateService.principal().getUsername(), fornecimento.getQuantidade(), fornecimento.getFornecedor())
		
		fornecimento.setDataRecebimento(dataAtual);
		
		if (!logInfo.save()) {
			throw new TransacaoEstoqueException("Impossível salvar o log!");
		}
		if (!fornecimento.save()) {
			throw new TransacaoEstoqueException("Impossível salvar o fornecimento!");
		}
	}
	
	def confirmarRealizacaoCompra(Compra compra) {
		if (compra.getDataRecebimento() != null) {
			throw new TransacaoEstoqueException("Compra ja confirmada!");
		}
		
		verificarCompra(compra);
		
		Date dataAtual = new Date()
		for (ItemDeVenda item : compra.getItens()) {
			item.getLente().setQuantidade(item.getLente().getQuantidade() - item.getQuantidadeComprada())
			
			def logInfo = new TransacaoEstoque(item.getLente(), dataAtual, TransacaoKind.VENDA, authenticateService.principal().getUsername(), item.getQuantidadeComprada(), null)
			if (!logInfo.save()) {
				throw new TransacaoEstoqueException("Impossível salvar o log!");
			}
		}
		
		compra.dataRecebimento = dataAtual;
		if (!compra.save()) {
			throw new TransacaoEstoqueException("Impossível salvar a compra!");
		}
	}
	
	def verificarCompra(Compra compra) {
		Map<Lente, Integer> pedidos = new HashMap<Lente, Integer>()
		for (ItemDeVenda item : compra.getItens()) {
			Integer qtdAtual = pedidos.get(item.getLente())
			if (qtdAtual == null) {
				qtdAtual = 0
			}
			pedidos.put(item.getLente(), qtdAtual + item.getQuantidadeComprada())
		}
		
		for (Lente lente : pedidos.keySet()) {
			Integer qtd = pedidos.get(lente)
			if (lente.getQuantidade() < qtd) {
				throw new TransacaoEstoqueException("Impossivel confirmar a compra! Quantidade em estoque da lente " + lente.getTipo() + " (quantidade: " + lente.getQuantidade() + ")" + " inferior &agrave; quantidade pedida (quantidade: " + qtd + ")");
			}
		}
	}
}
