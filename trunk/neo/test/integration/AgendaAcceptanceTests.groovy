import java.util.Calendar;

import core.FormaDePagamento 
import core.Medico 
import core.Paciente 
import core.Pagamento 
import core.ProcedimentoMedico 
import core.Sexo 
import core.TipoProcedimentoMedico 
import groovy.util.GroovyTestCase;

class AgendaAcceptanceTests extends GroovyTestCase  {
	void tearDown() {
		ProcedimentoMedico.list()*.delete();
		TipoProcedimentoMedico.list()*.delete();
		Pagamento.list()*.delete();
		Paciente.list()*.delete();
		Medico.list()*.delete();
	}
	
	/**
	 * Teste de Aceitação 12.1: Mostrar os procedimentos marcados para o dia atual (Operação Realizada com Sucesso se logado como Administrador ou Funcionário).	
	 */
	// obs.: "nas proximas 24h"
	void test12_1() {
		def p = new Paciente(nome: 'Jose', sexo: Sexo.MASCULINO, nascimento: new Date())
		p.save()
		def medicoValido = new Medico(
				username : 'renato',
				userRealName : 'renato',
				enabled : true,
				email : 'drrenato@gmail.com',
				passwd : 'drrenato',
				crm: '12441214',
				especialidade : 'Oftalmologista');
		medicoValido.save()
		def tipoProc = new TipoProcedimentoMedico(nome: 'Exame', valorBase: 10.0f)
		tipoProc.save()
		def tipoPag = new Pagamento(formaDePagamento: FormaDePagamento.DINHEIRO)
		tipoPag.save()
		
		
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		Date dataAtual = c.getTime();
		c.add(Calendar.DAY_OF_MONTH, 1);
		Date dataLimite = c.getTime();
		c.setTime(dataAtual);
		c.add(Calendar.DAY_OF_MONTH, 2);
		Date dataDoisDiasDepois = c.getTime();
		
		def procedimento = new ProcedimentoMedico(
				tipo : tipoProc,
				data : dataAtual,
				informacoes : 'Exames realizados na clinica',
				valor: 10.0f,
				pagamento: tipoPag,
				medico: medicoValido,
				paciente: p);
		procedimento.save()
			
		def procedimento2 = new ProcedimentoMedico(
				tipo : tipoProc,
				data : dataDoisDiasDepois,
				informacoes : 'Exames realizados na clinica',
				valor: 10.0f,
				pagamento: tipoPag,
				medico: medicoValido,
				paciente: p);
		procedimento2.save()
		
		def procedimento3 = new ProcedimentoMedico(
				tipo : tipoProc,
				data : dataLimite,
				informacoes : 'Exames realizados na clinica',
				valor: 10.0f,
				pagamento: tipoPag,
				medico: medicoValido,
				paciente: p);
		procedimento3.save()
		
		def procedimentos = ProcedimentoMedico.findAllByDataBetween(dataAtual, dataLimite);
		assertEquals 2, procedimentos.size();
		assertTrue procedimentos.contains(procedimento)
		assertFalse procedimentos.contains(procedimento2)
		assertTrue procedimentos.contains(procedimento3)
	}
	
	/**
	 * * Teste de Aceitação 12.2: Mostrar os procedimentos marcados para a semana (Operação Realizada com Sucesso se logado como Administrador ou Funcionário).
	 */
	// obs.: "nos proximos 7 dias"
	void test12_2() {
		def p = new Paciente(nome: 'Jose', sexo: Sexo.MASCULINO, nascimento: new Date())
		p.save()
		def medicoValido = new Medico(
				username : 'renato',
				userRealName : 'renato',
				enabled : true,
				email : 'drrenato@gmail.com',
				passwd : 'drrenato',
				crm: '12441214',
				especialidade : 'Oftalmologista');
		medicoValido.save()
		def tipoProc = new TipoProcedimentoMedico(nome: 'Exame', valorBase: 10.0f)
		tipoProc.save()
		def tipoPag = new Pagamento(formaDePagamento: FormaDePagamento.DINHEIRO)
		tipoPag.save()
		
		
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		Date dataAtual = c.getTime();
		c.add(Calendar.DAY_OF_MONTH, 7);
		Date dataLimite = c.getTime();
		c.setTime(dataAtual);
		c.add(Calendar.DAY_OF_MONTH, 8);
		Date dataApos = c.getTime();
		
		def procedimento = new ProcedimentoMedico(
				tipo : tipoProc,
				data : dataAtual,
				informacoes : 'Exames realizados na clinica',
				valor: 10.0f,
				pagamento: tipoPag,
				medico: medicoValido,
				paciente: p);
		procedimento.save()
			
		def procedimento2 = new ProcedimentoMedico(
				tipo : tipoProc,
				data : dataApos,
				informacoes : 'Exames realizados na clinica',
				valor: 10.0f,
				pagamento: tipoPag,
				medico: medicoValido,
				paciente: p);
		procedimento2.save()
		
		def procedimento3 = new ProcedimentoMedico(
				tipo : tipoProc,
				data : dataLimite,
				informacoes : 'Exames realizados na clinica',
				valor: 10.0f,
				pagamento: tipoPag,
				medico: medicoValido,
				paciente: p);
		procedimento3.save()
		
		def procedimentos = ProcedimentoMedico.findAllByDataBetween(dataAtual, dataLimite);
		assertEquals 2, procedimentos.size();
		assertTrue procedimentos.contains(procedimento)
		assertFalse procedimentos.contains(procedimento2)
		assertTrue procedimentos.contains(procedimento3)
	}
	
	/**
	 * * Teste de Aceitação 12.3: Mostrar os procedimentos marcados para o mês (Operação Realizada com Sucesso se logado como Administrador ou Funcionário). 
	 */
	// obs.: "nos proximos 30 dias"
	void test12_3() {
		def p = new Paciente(nome: 'Jose', sexo: Sexo.MASCULINO, nascimento: new Date())
		p.save()
		def medicoValido = new Medico(
				username : 'renato',
				userRealName : 'renato',
				enabled : true,
				email : 'drrenato@gmail.com',
				passwd : 'drrenato',
				crm: '12441214',
				especialidade : 'Oftalmologista');
		medicoValido.save()
		def tipoProc = new TipoProcedimentoMedico(nome: 'Exame', valorBase: 10.0f)
		tipoProc.save()
		def tipoPag = new Pagamento(formaDePagamento: FormaDePagamento.DINHEIRO)
		tipoPag.save()
		
		
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		Date dataAtual = c.getTime();
		c.add(Calendar.DAY_OF_MONTH, 30);
		Date dataLimite = c.getTime();
		c.setTime(dataAtual);
		c.add(Calendar.DAY_OF_MONTH, 31);
		Date dataApos = c.getTime();
		
		def procedimento = new ProcedimentoMedico(
				tipo : tipoProc,
				data : dataAtual,
				informacoes : 'Exames realizados na clinica',
				valor: 10.0f,
				pagamento: tipoPag,
				medico: medicoValido,
				paciente: p);
		procedimento.save()
			
		def procedimento2 = new ProcedimentoMedico(
				tipo : tipoProc,
				data : dataApos,
				informacoes : 'Exames realizados na clinica',
				valor: 10.0f,
				pagamento: tipoPag,
				medico: medicoValido,
				paciente: p);
		procedimento2.save()
		
		def procedimento3 = new ProcedimentoMedico(
				tipo : tipoProc,
				data : dataLimite,
				informacoes : 'Exames realizados na clinica',
				valor: 10.0f,
				pagamento: tipoPag,
				medico: medicoValido,
				paciente: p);
		procedimento3.save()
		
		def procedimentos = ProcedimentoMedico.findAllByDataBetween(dataAtual, dataLimite);
		assertEquals 2, procedimentos.size();
		assertTrue procedimentos.contains(procedimento)
		assertFalse procedimentos.contains(procedimento2)
		assertTrue procedimentos.contains(procedimento3)
	}
}
