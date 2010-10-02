package core

import java.util.Date;

/**
 * Classe de dominio pertencente ao "core" do sistema. Mantem as informacoes especificadas no modelo
 * de dados do projeto.
 */
class Paciente extends Pessoa {
	String profissao;
	String rg;
	
	/**
	 * Para guardarem informacoes adicionais que nao cabem ou nao fazem sentido nos outros campos
	 */
	String informacoesAdicionais;
	
	/**
	 * ID externo refere-se ao id do paciente no sistema ja em uso na clinica (PersonalMED)
	 */
	Integer idExterno;
	
	/**
	 * Define o relacionamento 1-1 unidirecional, paciente pertence a um convenio. Cria uma chave estrangeira
	 * para convenio.
	 */
	static belongsTo = [convenio : Convenio]
	
	/**
	 * Restricoes de integridade
	 */
	static constraints = {
		profissao(nullable : true, blank : true)
		rg(nullable : true, blank : true)
		informacoesAdicionais(nullable : true, maxSize : 1000)
		convenio(nullable : true)
		idExterno(nullable : true)
	}
}
