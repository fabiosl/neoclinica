_Obs.:_ Condição de Sucesso para todos os testes estão definidas após a descrição do teste (em itálico ou entre parenteses).


---


## User Story 1 - Estudar tecnologias da camada de dados ##

### Estimativa Inicial: 12 horas ###
### Testes de Aceitação ###

  * Teste de Aceitação 1.1: Verificar se exemplos gerados satisfazem os requisitos de CRUD e persistência desejados pelo cliente.  _Condição de sucesso: Dados guardados em esquema relacional de dados e com possibilidade de atualização, remoção, consulta e inserção_.

### Tempo Real: 9h10m ###


---


## User Story 2 - Configurar ambiente no servidor ##

### Estimativa Inicial: 8 horas ###
### Testes de Aceitação ###

  * Teste de Aceitação 2.1: Fazer uma requisição HTTP com sucesso ao servidor.  _Condição de sucesso: Requisição atendida pelo servidor_.

### Tempo Real: 11h15m ###


---


## User Story 3 - Estudar testes de aceitação em Grails ##

### Estimativa Inicial: 3 horas ###
### Testes de Aceitação ###

  * Teste de Aceitação 3.1: Elaboração de script de teste de aceitação.  _Condição de sucesso: Script realiza teste simples do sistema_.

### Tempo Real: 4h30m ###


---


## User Story 4 - Implementar funcionalidade de login com privilégios ##
O sistema deve ter logins com dois níveis de privilégio (administrador e funcionário).

### Estimativa Inicial: 5 horas ###
### Testes de Aceitação ###

  * Teste de Aceitação 4.1: Fazer login com usuário do tipo "administrador" (login com sucesso).
  * Teste de Aceitação 4.2: Fazer login com usuário do tipo "funcionario" (login com sucesso).
  * Teste de Aceitação 4.3: Fazer login com usuário do tipo "administrador" (login sem sucesso).
  * Teste de Aceitação 4.4: Fazer login com usuário do tipo "funcionario" (login sem sucesso).

### Tempo Real: 4h ###


---


## User Story 5 - Implementar funcionalidade de controle de pacientes ##
O sistema deve prover o controle dos pacientes da clínica. Ele armazenará dados básicos sobre esses pacientes.

### Estimativa Inicial: 10 horas ###
### Testes de Aceitação ###

  * Teste de Aceitação 5.1: Cadastrar um cliente com todos os dados corretos (Cadastro Realizado com Sucesso).
  * Teste de Aceitação 5.2: Cadastrar um cliente com dados obrigatórios faltando (Cadastro não Realizado).
  * Teste de Aceitação 5.3: Retirar paciente existente da lista dos pacientes (Operação Realizada com Sucesso).
  * Teste de Aceitação 5.4: Retirar paciente inexistente da lista dos pacientes (Operação Realizada sem Sucesso).
  * Teste de Aceitação 5.5: Atualizar dados de paciente existente no sistema (Operação Realizada com Sucesso).
  * Teste de Aceitação 5.6: Atualizar dados de paciente inexistente no sistema (Operação Realizada sem Sucesso).

### Tempo Real: 6h37m ###

---


## User Story 6 - Implementar funcionalidade de controle de usuários do sistema ##
O sistema deve prover o controle dos usuários que o utilizam.

### Estimativa Inicial: 8 horas ###
### Testes de Aceitação ###

  * Teste de Aceitação 6.1: Cadastrar um usuário com todos os dados corretos (Cadastro Realizado com Sucesso - se logado como administrador).
  * Teste de Aceitação 6.2: Cadastrar um usuário com todos os dados corretos (Cadastro Realizado sem Sucesso - se não logado como administrador).
  * Teste de Aceitação 6.3: Cadastrar um usuário com dados obrigatórios faltando (Cadastro Realizado sem Sucesso - se logado como administrador ou secretária).
  * Teste de Aceitação 6.4: Retirar usuário existente (Operação Realizada com Sucesso - se logado como administrador).
  * Teste de Aceitação 6.5: Retirar usuário existente (Operação Realizada sem Sucesso - se logado como funcionario)
  * Teste de Aceitação 6.6: Retirar usuário inexistente (Operação Realizada sem Sucesso - se logado como administrador ou funcionario).
  * Teste de Aceitação 6.7: Atualizar dados do usuário logado (Operação Realizada com Sucesso - se logado com o usuário que se quer editar os dados).

### Tempo Real: 7h01m ###

---


## User Story 7 - Implementar funcionalidade de controle do estoque de lentes ##
O sistema deve prover o controle do estoque de lentes da clínica. Cada lente possui várias informações que devem ser armazenadas.

### Estimativa Inicial: 5 horas ###
### Testes de Aceitação ###

  * Teste de Aceitação 7.1: Cadastrar novo tipo de lente com todos os dados corretos (Operação Realizada com Sucesso).
  * Teste de Aceitação 7.2: Cadastrar novo tipo de lente com dados faltando (Operação Realizada sem Sucesso).
  * Teste de Aceitação 7.3: Remover tipo de lente existente no sistema (Operação Realizada com Sucesso).
  * Teste de Aceitação 7.4: Remover tipo de lente inexistente no sistema (Operação Realizada sem Sucesso).
  * Teste de Aceitação 7.5: Consultar quantidade de lentes de um certo tipo (existente no sistema) disponíveis (Operação Realizada com Sucesso).
  * Teste de Aceitação 7.6: Consultar quantidade de lentes de um certo tipo (inexistente no sistema) disponíveis (Operação Realizada com Sucesso).
  * Teste de Aceitação 7.7: Modificar a quantidade de lentes de um certo tipo (existente no sistema) disponíveis (Operação Realizada com Sucesso).
  * Teste de Aceitação 7.8: Modificar a quantidade de lentes de um certo tipo (inexistente no sistema) disponíveis (Operação Realizada sem Sucesso).

### Tempo Real: 3h30m ###

---


## User Story 8 - Implementar funcionalidade de cadastro de fornecedores ##
O sistema deve armazenar os fornecedores de lentes da clínica.

### Estimativa Inicial: 5 horas ###
### Testes de Aceitação ###

  * Teste de Aceitação 8.1: Cadastrar fornecedor no sistema com todos os dados corretos (Operação Realizada com Sucesso).
  * Teste de Aceitação 8.2: Cadastrar fornecedor no sistema com dados faltando (Operação Realizada sem Sucesso).
  * Teste de Aceitação 8.3: Retirar fornecedor existente da lista dos fornecedores (Operação Realizada com Sucesso).
  * Teste de Aceitação 8.4: Retirar fornecedor inexistente da lista dos fornecedores (Operação Realizada sem Sucesso).
  * Teste de Aceitação 8.5: Consultar dados de fornecedor existente no sistema (Operação Realizada com Sucesso).
  * Teste de Aceitação 8.6: Consultar dados de fornecedor inexistente no sistema (Operação Realizada sem Sucesso).
  * Teste de Aceitação 8.7: Atualizar dados de fornecedor existente no sistema (Operação Realizada com Sucesso).
  * Teste de Aceitação 8.8: Atualizar dados de fornecedor inexistente no sistema (Operação Realizada sem Sucesso).

### Tempo Real: 5h06m ###

---


## User Story 9 - Implementar funcionalidade de controle de procedimentos ##
O sistema deve prover controle dos procedimentos (procedimentos médicos e compras) realizados na clínica.

### Estimativa Inicial: 10 horas ###
### Testes de Aceitação ###

  * Teste de Aceitação 9.1: Cadastrar procedimento no sistema com todos os dados corretos (Operação Realizada com Sucesso).
  * Teste de Aceitação 9.2: Cadastrar procedimento no sistema com dados faltando (Operação Realizada sem Sucesso).
  * Teste de Aceitação 9.3: Retirar procedimento existente da lista de procedimentos (Operação Realizada com Sucesso).
  * Teste de Aceitação 9.4: Retirar procedimento inexistente da lista de procedimentos (Operação Realizada sem Sucesso).
  * Teste de Aceitação 9.5: Consultar dados de procedimento existente no sistema (Operação Realizada com Sucesso).
  * Teste de Aceitação 9.6: Consultar dados de procedimento inexistente no sistema (Operação Realizada sem Sucesso).
  * Teste de Aceitação 9.7: Atualizar dados de procedimento existente no sistema (Operação Realizada com Sucesso).
  * Teste de Aceitação 9.8: Atualizar dados de procedimento inexistente no sistema (Operação Realizada sem Sucesso).

### Tempo Real: 18h12m ###

---


## User Story 10 - Implementar funcionalidade de emissão de relatórios financeiros ##
O sistema deve emitir relatórios financeiros das atividades realizadas na clínica. Esses relatórios podem ser organizados em diferentes categorias: por data; por médico; por procedimento médico; por lentes vendidas; por paciente e por convênio médico.

### Estimativa Inicial: 8 horas ###
### Testes de Aceitação ###

  * Teste de Aceitação 10.1: Emitir relatório por data dos procedimentos médicos realizadas (Operação Realizada com Sucesso se logado como Administrador ou Funcionário).
  * Teste de Aceitação 10.2: Emitir relatório por data das vendas de lentes realizadas (Operação Realizada com Sucesso se logado como Administrador ou Funcionário).

### Tempo Real: 9h42m ###

---


## User Story 11 - Implementar funcionalidade de emissão de relatórios de estoque ##
O sistema deve emitir relatórios do estoque de lentes para consulta por parte dos médicos.

### Estimativa Inicial: 2 horas ###
### Testes de Aceitação ###

  * Teste de Aceitação 11.1: Emitir relatório do estoque disponível de lentes (Operação Realizada com Sucesso se logado como Administrador).
  * Teste de Aceitação 11.2: Emitir relatório da atividade do estoque de lentes (Operação Realizada com Sucesso se logado como Administrador).

### Tempo Real: 9h33m ###

---


## User Story 12 - Implementar funcionalidade de agenda médica ##
O sistema deve prover aos usuários (médicos e secretárias) informações sobre os procedimentos médicos a serem realizados, bem como informações sobre os pacientes relacionados.

### Estimativa Inicial: 10 horas ###
### Testes de Aceitação ###

  * Teste de Aceitação 12.1: Mostrar os procedimentos marcados para o dia atual (Operação Realizada com Sucesso se logado como Administrador ou Funcionário).
  * Teste de Aceitação 12.2: Mostrar os procedimentos marcados para a semana (Operação Realizada com Sucesso se logado como Administrador ou Funcionário).
  * Teste de Aceitação 12.3: Mostrar os procedimentos marcados para o mês (Operação Realizada com Sucesso se logado como Administrador ou Funcionário).

### Tempo Real: 4h06m ###

---


## User Story 13 - Implementar funcionalidade de relatório de paciente ##
O sistema deve permitir busca por nome dos pacientes no sistema, que deve retornar uma lista em ordem alfanumérica (nome e número), com a opção de exibir relatório com os dados pessoais dos clientes, assim como as informações dos procedimentos médicos realizados e agendados.

### Estimativa Inicial: 8 horas ###
### Testes de Aceitação ###

  * Teste de Aceitação 13.1: Pesquisar dados de paciente existente no sistema (Operação Realizada com Sucesso).
  * Teste de Aceitação 13.2: Pesquisar dados de paciente inexistente no sistema (Operação Realizada sem Sucesso).

### Tempo Real: 3h36m ###

---


## User Story 14 - Elaborar Manual de Configuração do Sistema ##
Deve ser elaborado um manual de configuração do sistema para a equipe de desenvolvimento e para o usuário.

### Estimativa Inicial: 1 hora ###
### Testes de Aceitação ###
  * Teste de Aceitação 14.1: Manual do sistema.  _Condição de sucesso: Instalar corretamente ambiente em máquina que não o tem instalado_.

### Tempo Real: 1h17m ###

---


## User Story 15 - Implementar funcionalidade de controle de médicos ##
O sistema deve prover controle dos médicos que trabalham na clínica (usado para gerência das consultas).

### Estimativa Inicial: 5 horas ###
### Testes de Aceitação ###
  * Teste de Aceitação 15.1: Cadastrar médico no sistema com todos os dados corretos (Operação Realizada com Sucesso).
  * Teste de Aceitação 15.2: Cadastrar médico no sistema com dados faltando (Operação Realizada sem Sucesso).
  * Teste de Aceitação 15.3: Retirar médico existente da lista de médicos (Operação Realizada com Sucesso).
  * Teste de Aceitação 15.4: Retirar médico inexistente da lista de médico (Operação Realizada sem Sucesso).
  * Teste de Aceitação 15.5: Consultar dados de médico existente no sistema (Operação Realizada com Sucesso).
  * Teste de Aceitação 15.6: Consultar dados de médico inexistente no sistema (Operação Realizada sem Sucesso).
  * Teste de Aceitação 15.7: Atualizar dados de médico existente no sistema (Operação Realizada com Sucesso).
  * Teste de Aceitação 15.8: Atualizar dados de médico inexistente no sistema (Operação Realizada sem Sucesso).

### Tempo Real: 04h50m ###

---


## User Story 16 - Implementar solução de backup automático do banco de dados. ##

### Estimativa Inicial: 4 horas ###
### Testes de Aceitação ###
  * Teste de Aceitação 16.1: Realizar backup automático em certo intervalo configurável por script. _Condição de sucesso: Script realiza backup do banco de dados do sistema_.

### Tempo Real: 1h ###

---



_OBS. (17/11/2010):_ Atualizamos as US com a nova funcionalidade pedia pelo cliente (solução de backup automático), priorizada em relação aos relatórios XLS.