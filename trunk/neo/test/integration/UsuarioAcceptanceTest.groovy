import acesso.Usuario 
import groovy.util.GroovyTestCase;

/**
 * Testes de aceitacao da user story 6 (Implementar funcionalidade de controle de usuários do sistema)
 */
class UsuarioAcceptanceTest extends GroovyTestCase{
	void tearDown() {
		Usuario.list()*.delete();
	}
	
	/**
	 * Teste de Aceitação 6.1: Cadastrar um usuário com todos os dados corretos
	 */
	void test6_1(){
		def userOne = new Usuario(username: 'solon', passwd: '12345', userRealName: 'Solon Aguiar', enabled : true, email : 'solon@gmail.com')
		assertTrue userOne.validate()
		userOne.save()
		assertNotNull Usuario.findByUsername('solon')
		assertNotNull Usuario.findByUserRealName('Solon Aguiar')
		
		def userTwo = new Usuario(username: 'aguiar', passwd: '45678', userRealName: 'Severino Aguiar', enabled : true, email : 'aguiar@gmail.com')
		assertTrue userTwo.validate()
		userTwo.save()
		assertNotNull Usuario.findByUsername('aguiar')
		assertNotNull Usuario.findByUserRealName('Severino Aguiar')
	}
	
	/**
	 * Teste de Aceitação 6.3: Cadastrar um usuário com dados obrigatórios faltando(Cadastro Realizado sem Sucesso) 
	 */
	
	void test6_3(){
		def userOne = new Usuario(username: 'solon', userRealName: 'Solon Aguiar', enabled : true, email : 'solon@gmail.com')
		assertFalse userOne.validate()
		userOne.save()
		assertNull Usuario.findByUsername('solon')
		assertNull Usuario.findByUserRealName('Solon Aguiar')
		
		def userTwo = new Usuario(username: 'aguiar', passwd: '45678', enabled : true, email : 'aguiar@gmail.com')
		assertFalse userTwo.validate()
		userTwo.save()
		assertNull Usuario.findByUsername('aguiar')
		assertNull Usuario.findByUserRealName('Severino Aguiar')
	}
	
	/**
	 * Teste de Aceitação 6.4: Retirar usuário existente (Operação Realizada com Sucesso
	 */
	void test6_4(){
		def userOne = new Usuario(username: 'solon', passwd: '12345', userRealName: 'Solon Aguiar', enabled : true, email : 'solon@gmail.com')
		assertTrue userOne.validate()
		userOne.save()
		assertNotNull Usuario.findByUsername('solon')
		assertNotNull Usuario.findByUserRealName('Solon Aguiar')
		def user = Usuario.findByUsername('solon')
		user.delete()
		assertNull Usuario.findByUsername('solon')
		assertNull Usuario.findByUserRealName('Solon Aguiar')
		
		def userTwo = new Usuario(username: 'aguiar', passwd: '45678', userRealName: 'Severino Aguiar', enabled : true, email : 'aguiar@gmail.com')
		assertTrue userTwo.validate()
		userTwo.save()
		assertNotNull Usuario.findByUsername('aguiar')
		assertNotNull Usuario.findByUserRealName('Severino Aguiar')
		def otherUuser = Usuario.findByUsername('aguiar')
		otherUuser.delete()
		assertNull Usuario.findByUsername('aguiar')
		assertNull Usuario.findByUserRealName('Severino Aguiar')
	}
	
	/**
	 * Teste de Aceitação 6.6: Retirar usuário inexistente (Operação Realizada sem Sucesso)
	 */
	void test6_6(){
		def userOne = new Usuario(username: 'solon', passwd: '12345', userRealName: 'Solon Aguiar', enabled : true, email : 'solon@gmail.com')
		assertTrue userOne.validate()
		assertNull Usuario.findByUsername('solon')
		assertNull Usuario.findByUserRealName('Solon Aguiar')
		userOne.delete()
		assertNull Usuario.findByUsername('solon')
		assertNull Usuario.findByUserRealName('Solon Aguiar')
		
		def userTwo = new Usuario(username: 'aguiar', passwd: '45678', userRealName: 'Severino Aguiar', enabled : true, email : 'aguiar@gmail.com')
		assertTrue userTwo.validate()
		assertNull Usuario.findByUsername('aguiar')
		assertNull Usuario.findByUserRealName('Severino Aguiar')
		userTwo.delete()
		assertNull Usuario.findByUsername('aguiar')
		assertNull Usuario.findByUserRealName('Severino Aguiar')
	}
}
