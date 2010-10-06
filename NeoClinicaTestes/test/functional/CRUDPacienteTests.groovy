
class CRUDPacienteTests extends functionaltestplugin.FunctionalTestCase {
	private String defaultLocation =  "http://localhost:9000/NEOSoftGrails/login/auth";
	
//   Integer idPacCriado;
	
	void testAddPacienteOK() {
		get(this.defaultLocation);
		form('loginForm') {
			j_username = "harrison"
			j_password = "harrison"
			click "OK"
		}
		click "linkpaciente"
		click "linkadicionarpaciente"
		
		form('formAddPaciente') {
			nome = "Paciente1"
			endereco = "enderecoDoPaciente"
			telefone = "323223"
			sexo = "MASCULINO"
			//dataNascimento default
			click "create"
		}
		
//		this.idPacCriado = byId("pacienteCriadoMessage").getTextContent().split(" ")[1];
		assertContentContains "criado"
	}
	
	void testAddPacienteNotOk() {
		get(this.defaultLocation);
		form('loginForm') {
			j_username = "harrison"
			j_password = "harrison"
			click "OK"
		}
		
		click "linkpaciente"
		click "linkadicionarpaciente"
		form('formAddPaciente') {
			//Dados obrigatorios nao preenchidos
			click "create"
		}
		assertContentContains "O campo [nome] n&atilde;o pode ficar em branco"
	}
	void testRemovePacienteOk() {
		//remove o paciente criado no teste testAddPacienteOK.
			get(this.defaultLocation);
		form('loginForm') {
			j_username = "harrison"
			j_password = "harrison"
			click "OK"
		}
		click "linkpaciente"
		click "linkadicionarpaciente"
		
		form('formAddPaciente') {
			nome = "Paciente1"
			endereco = "enderecoDoPaciente"
			telefone = "323223"
			sexo = "MASCULINO"
			//dataNascimento default
			click "create"
		}
		
//		this.idPacCriado = byId("pacienteCriadoMessage").getTextContent().split(" ")[1];
		assertContentContains "criado"
		click "deletar"
		assertContentContains "deletado"
		
		
	}	
	
	void testRemovePacienteNotOk() {
		//remove o paciente criado no teste testAddPacienteOK.
			get(this.defaultLocation);
		form('loginForm') {
			j_username = "harrison"
			j_password = "harrison"
			click "OK"
		}
		click "linkpaciente"
		click "linkadicionarpaciente"
		
		form('formAddPaciente') {
			nome = "Paciente1"
			endereco = "enderecoDoPaciente"
			telefone = "323223"
			sexo = "MASCULINO"
			//dataNascimento default
			click "create"
		}
		
		assertNull byId("0")
		
		
	}
	
	void testEditPacientetOk() {
		//remove o paciente criado no teste testAddPacienteOK.
			get(this.defaultLocation);
		form('loginForm') {
			j_username = "harrison"
			j_password = "harrison"
			click "OK"
		}
		click "linkpaciente"
		click "linkadicionarpaciente"
		
		form('formAddPaciente') {
			nome = "Paciente1"
			endereco = "enderecoDoPaciente"
			telefone = "323223"
			sexo = "MASCULINO"
			//dataNascimento default
			click "create"
		}
		
		click "editar"
		
		form('formEditPaciente') {
			endereco = "Rodrigues Alves"
			click "atualizar"
		}
		
		assertContentContains "atualizado"
		
	}
	
	
		
	
}
