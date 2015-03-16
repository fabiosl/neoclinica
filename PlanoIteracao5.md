# Iteração 5 (_04/11/2010 -> 17/11/2010_) #

Usando a legenda para o status das US:
  * C: Concluída;
  * A: Abortado;
  * D: Desenvolvimento.


---


## User Story 10 - Implementar funcionalidade de emissão de relatórios financeiros ##
### Testes de Aceitação ###
  * Teste de Aceitação 10.1: Emitir relatório por data dos procedimentos médicos realizadas (Operação Realizada com Sucesso se logado como Administrador ou Funcionário).
  * Teste de Aceitação 10.2: Emitir relatório por data das vendas de lentes realizadas (Operação Realizada com Sucesso se logado como Administrador ou Funcionário).


### Atividades ###
| **Atividade** | **Descrição** | **Responsável** | **Estimativa** | **Tempo Real** | **Status** |
|:--------------|:----------------|:-----------------|:---------------|:---------------|:-----------|
| A10.1 | Realizar Testes | Solon | 2h | 2h23m | C |
| A10.2 | Elaborar GSP's | Renato | 40min | 24m | C |
| A10.3 | Avaliar alternativas para geraçao de XLS's do plugin Jasper _(ver observação)_ | Fabio | 2h | 0h  | C |
| A10.4 | Gerar arquivos .jrxml | Fabio | 1h | 1h15m | C |
| A10.5 | Realizar test review | Solon | 4h | 5h36m | C |

_Obs.:_ Atividade abandonada pelos mesmos motivos do [risco](http://code.google.com/p/neoclinica/wiki/Riscos), mudança de prioridade do cliente.

## User Story 13 - Implementar funcionalidade de relatório de paciente ##
### Testes de Aceitação ###
  * Teste de Aceitação 13.1: Pesquisar dados de paciente existente no sistema (Operação Realizada com Sucesso).
  * Teste de Aceitação 13.2: Pesquisar dados de paciente inexistente no sistema (Operação Realizada sem Sucesso).

### Atividades ###

| **Atividade** | **Descrição** | **Responsável** | **Estimativa** | **Tempo Real** | **Status** |
|:--------------|:----------------|:-----------------|:---------------|:---------------|:-----------|
| A13.1 | Implementação das páginas GSP's | Renato, Solon | 3h | 54m | C |
| A13.2 | Implementação das controladoras necessárias | Renato | 2h | 1h42m | C |
| A13.3 | Realizar testes | Fabio | 2h | 1h | C |