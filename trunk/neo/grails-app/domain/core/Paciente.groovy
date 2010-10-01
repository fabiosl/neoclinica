package core

import java.util.Date;

/**
 * Classe de domínio pertencente ao "core" do sistema. Mantem as informacoes especificadas no modelo
 * de dados do projeto.
 */
class Paciente extends Pessoa {
	String profissao;
	String rg;
	Convenio convenio;
	
	
	
	/**
	 * Para guardarem informacoes adicionais que nao cabem ou nao fazem sentido nos outros campos
	 */
	String informacoesAdicionais;
	
	/**
	 * ID externo refere-se ao id do paciente no sistema ja em uso na clinica (PersonalMED)
	 */
	Integer idExterno;
	
	static constraints = {
		profissao(nullable : true, blank : true)
		rg(nullable : true, blank : true)
		informacoesAdicionais(nullable : true, maxSize : 1000)
		convenio(nullable:true)
		idExterno(nullable : true)
	}
}
