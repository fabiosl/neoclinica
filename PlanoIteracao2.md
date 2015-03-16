# Iteração 2 (_23/09/2010 -> 06/10/2010_) #

_**As estimativas de tempo, se somadas, para a User Story 5 têm valores diferentes das estimadas inicialmente (na página das User Stories), pois já houve ganho de experiência na Iteração 1 em relação a implementação de CRUDs e melhorias de GSPs.**_

Usando a legenda para o status das US:
  * C: Concluída;
  * A: Abortado;
  * D: Desenvolvimento.


---


## User Story 5 - Implementar funcionalidade de controle de pacientes ##

### Testes de Aceitação ###

  * Teste de Aceitação 5.1: Cadastrar um cliente com todos os dados corretos (Cadastro Realizado com Sucesso).
  * Teste de Aceitação 5.2: Cadastrar um cliente com dados obrigatórios faltando (Cadastro não Realizado).
  * Teste de Aceitação 5.3: Retirar paciente existente da lista dos pacientes (Operação Realizada com Sucesso).
  * Teste de Aceitação 5.4: Retirar paciente inexistente da lista dos pacientes (Operação Realizada sem Sucesso).
  * Teste de Aceitação 5.5: Atualizar dados de paciente existente no sistema (Operação Realizada com Sucesso).
  * Teste de Aceitação 5.6: Atualizar dados de paciente inexistente no sistema (Operação Realizada sem Sucesso).

### Atividades ###

| **Atividade** | **Descrição** | **Responsável** | **Estimativa** | **Tempo Real** | **Status** |
|:--------------|:----------------|:-----------------|:---------------|:---------------|:-----------|
| A5.1 | Implementação das classes de domínio | Renato | 1h | 40m| C |
| A5.2 | Implementação da lógica de CRUD | Renato | 2h | 1h12m | C |
| A5.3 | Elaboração das páginas GSP's | Solon | 3h | 2h30m| C |
| A5.4 | Realização dos Testes | Fábio | 2h | 2h15m | C |


---


## User Story 6 - Implementar funcionalidade de controle de usuários do sistema ##

### Testes de Aceitação ###

  * Teste de Aceitação 6.1: Cadastrar um usuário com todos os dados corretos (Cadastro Realizado com Sucesso - se logado como administrador).
  * Teste de Aceitação 6.2: Cadastrar um usuário com todos os dados corretos (Cadastro Realizado sem Sucesso - se não logado como administrador).
  * Teste de Aceitação 6.3: Cadastrar um usuário com dados obrigatórios faltando (Cadastro Realizado sem Sucesso - se logado como administrador ou secretária).
  * Teste de Aceitação 6.4: Retirar usuário existente (Operação Realizada com Sucesso - se logado como administrador).
  * Teste de Aceitação 6.5: Retirar usuário existente (Operação Realizada sem Sucesso - se logado como funcionario)
  * Teste de Aceitação 6.6: Retirar usuário inexistente (Operação Realizada sem Sucesso - se logado como administrador ou funcionario).
  * Teste de Aceitação 6.7: Atualizar dados do usuário logado (Operação Realizada com Sucesso - se logado com o usuário que se quer editar os dados).

### Atividades ###

| **Atividade** | **Descrição** | **Responsável** | **Estimativa** | **Tempo Real** | **Status** |
|:--------------|:----------------|:-----------------|:---------------|:---------------|:-----------|
| A6.1 | Implementação das classes de domínio | Solon | 1h | 45m | C |
| A6.2 | Implementação da lógica de CRUD | Renato | 2h | 1h36m| C |
| A6.3 | Elaboração das páginas GSP's | Fabio | 2h | 1h | C |
| A6.4 | Realizar testes | Fabio | 2h | 2h10m | C |
| A6.5 | Mudança de senha para usuário logado | Renato | 1h | 1h30m | C |


---