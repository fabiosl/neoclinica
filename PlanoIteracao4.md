# Iteração 4 (_21/10/2010 -> 03/11/2010_) #

Usando a legenda para o status das US:
  * C: Concluída;
  * A: Abortado;
  * D: Desenvolvimento.


---


## User Story 9 - Implementar funcionalidade de controle do controle de procedimentos ##

### Testes de Aceitação ###

  * Teste de Aceitação 9.1: Cadastrar procedimento no sistema com todos os dados corretos (Operação Realizada com Sucesso).
  * Teste de Aceitação 9.2: Cadastrar procedimento no sistema com dados faltando (Operação Realizada sem Sucesso).
  * Teste de Aceitação 9.3: Retirar procedimento existente da lista de procedimentos (Operação Realizada com Sucesso).
  * Teste de Aceitação 9.4: Retirar procedimento inexistente da lista de procedimentos (Operação Realizada sem Sucesso).
  * Teste de Aceitação 9.5: Consultar dados de procedimento existente no sistema (Operação Realizada com Sucesso).
  * Teste de Aceitação 9.6: Consultar dados de procedimento inexistente no sistema (Operação Realizada sem Sucesso).
  * Teste de Aceitação 9.7: Atualizar dados de procedimento existente no sistema (Operação Realizada com Sucesso).
  * Teste de Aceitação 9.8: Atualizar dados de procedimento inexistente no sistema (Operação Realizada sem Sucesso).


### Atividades ###

| **Atividade** | **Descrição** | **Responsável** | **Estimativa** | **Tempo Real** | **Status** |
|:--------------|:----------------|:-----------------|:---------------|:---------------|:-----------|
| A9.1 | Implementação das classes de domínio | Solon | 45m | 42m | C |
| A9.2 | Implementação da lógica de CRUD | Solon | 1h | 30m | C |
| A9.3 | Elaboração das páginas GSP's | Renato | 3h | 8h | C |
| A9.4 | Realização dos Testes | Fabio, Renato | 3h | 2h | C |
| A9.5 | Integrar controle de procedimentos com estoque | Renato | 4h | 3h |C |
| A9.6 | Integrar controle de procedimentos com medicos | Fabio| 4h | 4h | C |

## User Story 11 - Implementar funcionalidade emissão de relatórios do estoque ##

### Testes de Aceitação ###
  * Teste de Aceitação 11.1: Emitir relatório do estoque disponível de lentes (Operação Realizada com Sucesso se logado como Administrador).
  * Teste de Aceitação 11.2: Emitir relatório da atividade do estoque de lentes (Operação Realizada com Sucesso se logado como Administrador).

### Atividades ###

| **Atividade** | **Descrição** | **Responsável** | **Estimativa** | **Tempo Real** | **Status** |
|:--------------|:----------------|:-----------------|:---------------|:---------------|:-----------|
| A11.1 | Estudo do plugin de geração de relatórios Jasper | Todos | 1h 30m | 2h | C |
| A11.2 | Estudo de plugin de envio de emails | Todos | 2h | 2h20m | C |
| A11.3 | Elaboração das GSP's | Fabio | 2h | 1h30m | C |
| A11.4 | Implementacao das classes | Solon | 5h | 3h23m | C |
| A11.5 | Realização dos testes | Renato | 2h | 2h20m | C |