# Iteração 6 (_18/11/2010 -> 01/12/2010_) #

Usando a legenda para o status das US:
  * C: Concluída;
  * A: Abortado;
  * D: Desenvolvimento.


---


## User Story 12 - Implementar funcionalidade de agenda médica ##
### Testes de Aceitação ###

  * Teste de Aceitação 12.1: Mostrar os procedimentos marcados para o dia atual (Operação Realizada com Sucesso se logado como Administrador ou Funcionário).
  * Teste de Aceitação 12.2: Mostrar os procedimentos marcados para a semana (Operação Realizada com Sucesso se logado como Administrador ou Funcionário).
  * Teste de Aceitação 12.3: Mostrar os procedimentos marcados para o mês (Operação Realizada com Sucesso se logado como Administrador ou Funcionário).

### Atividades ###
| **Atividade** | **Descrição** | **Responsável** | **Estimativa** | **Tempo Real** | **Status** |
|:--------------|:----------------|:-----------------|:---------------|:---------------|:-----------|
| A12.1 | Implementação das páginas GSPs usando plugin richui | Solon | 1h | 42m | C |
| A12.2 | Implementação das controladoras necessárias | Renato, Solon | 2h |1h18m| C |
| A12.3 | Realizar testes | Renato | 1h | 1h06m | C |
| A12.4 | Analisar possibilidade de alterar skin da agenda no plugin richui para exibir hora de 15 em 15min | Solon | 2h | 1h | C |


---


## User Story 16 - Implementar solução de backup automático do banco de dados. ##
### Testes de Aceitação ###
  * Teste de Aceitação 16.1: Realizar backup automático em certo intervalo configurável por script.

### Atividades ###

| **Atividade** | **Descrição** | **Responsável** | **Estimativa** | **Tempo Real** | **Status** |
|:--------------|:----------------|:-----------------|:---------------|:---------------|:-----------|
| A16.1 | Estudo da solução de backup automático com MySQL | Todos | 1h | 1h | C |
| A16.2 | Elaborar script _(ver observação)_  | Fábio | 3h | 0h | C |
| A16.3 | Testar script _(ver observação)_  no ambiente do servidor | Fábio | 1h | 0h| C |

_Obs.:_ Estas atividades não foram necessárias, pois após [estudo](http://code.google.com/p/neoclinica/source/browse/trunk/neo/test/acceptance/us16/Backup%20do%20SI%20NEO.docx) vimos que o MySQL automatiza esta tarefa através do Mysql Administrator.