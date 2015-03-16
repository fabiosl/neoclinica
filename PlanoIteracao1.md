# Iteração 1 (_08/09/2010 -> 22/09/2010_) #

Usando a legenda para o status das US:
  * C: Concluída;
  * A: Abortado;
  * D: Desenvolvimento.

Os artefatos produzidos como resultados podem ser encontrados em links após as descrições dos testes de aceitação.


---


## User Story 1 - Estudar tecnologias da camada de dados ##

As tecnologias a ser estudadas compreendem àquelas que farão o  mapeamento que das classes do sistema que precisam ser guardadas para um SGBD escolhido (no caso, MySQL). Também estava previsto o estudo do padrão DAO, mas não o foi necessário já que Grails faz todo o mapeamento de acesso e controle dos dados de maneira automática.

### Testes de Aceitação ###

  * Teste de Aceitação 1.1: Verificar se exemplos gerados satisfazem os requisitos de CRUD e persistência desejados pelo cliente. _Condição de sucesso: Dados guardados em esquema relacional de dados e com possibilidade de atualização, remoção, consulta e inserção_.

**Artefatos Produzidos: [(Ver Observações)](http://code.google.com/p/neoclinica/source/browse/trunk/neo/test/acceptance/us1/Observação.txt), [Manual Integração MySQL](http://code.google.com/p/neoclinica/source/browse/trunk/neo/test/acceptance/us1/Guia%20Integração.txt), [Estudo Padrão DAO](http://code.google.com/p/neoclinica/source/browse/trunk/neo/test/acceptance/us1/Padrão%20DAO.txt)**

### Atividades ###

| **Atividade** | **Descrição** | **Responsável** | **Estimativa** | **Tempo Real** | **Status** |
|:--------------|:----------------|:-----------------|:---------------|:---------------|:-----------|
| A1.1 | Estudar MySQL e padrão DAO | Todos | 2h | 1h25m | C |
| A1.2 | Estudar integração de Grails com MySQL | Renato | 2h | 1h15m | C |
| A1.3 | Configurar integração de Grails com MySQL no projeto | Renato | 4h | 3h | C |
| A1.4 | Gerar classes de domínio Grails seguindo o modelo de dados para testar mapeamento | Renato | 4h | 3h30m | C |


---


## User Story 2 - Configurar ambiente no servidor ##

### Testes de Aceitação ###

  * Teste de Aceitação 2.1: Fazer uma requisição HTTP com sucesso ao servidor. _Condição de sucesso: Requisição atendida pelo servidor_.

**Artefatos Produzidos: [(Ver Observação)](http://code.google.com/p/neoclinica/source/browse/trunk/neo/test/acceptance/us2/Observação.txt) - Só funcionará quando o servidor estiver rodando**

### Atividades ###

| **Atividade** | **Descrição** | **Responsável** | **Estimativa** | **Tempo Real** | **Status** | **Observação** |
|:--------------|:----------------|:-----------------|:---------------|:---------------|:-----------|:-----------------|
| A2.1 | Instalar Tomcat | Fabio | 1h | 30m | C | Cliente ainda não providenciou o servidor. |
| A2.2 | Instalar cliente no-ip | Fabio | 1h | 1h30m | C | www.clinicaneo.sytes.net |
| A2.3 | Instalar MySQL | Fabio | 1h | 48m | C | Cliente ainda não providenciou o servidor.|
| A2.4 | Instalar Grails | Fabio | 2h | 1h15m | C | Cliente ainda não providenciou o servidor. |
| A2.5 | Realizar integração do sistema com o servidor | Fabio | 3h | 7h12m | C | Cliente ainda não providenciou o servidor.|


---


## User Story 3 - Estudo de testes de aceitação em Grails ##

### Testes de Aceitação ###

  * Teste de Aceitação 3.1: Elaboração de script de teste de aceitação. _Condição de sucesso: Script realiza teste simples do sistema_.

**Artefatos Produzidos: [(Ver Observação)](http://code.google.com/p/neoclinica/source/browse/trunk/neo/test/acceptance/us3/README.txt), [Estudo das Ferramentas](http://code.google.com/p/neoclinica/source/browse/trunk/neo/test/acceptance/us3/Estudo%20das%20ferramentas%20de%20testes%20de%20aceita%C3%A7%C3%A3o%20para%20o%20projeto%20ClinicaNeoSI.docx)**

### Atividades ###

| **Atividade** | **Descrição** | **Responsável** | **Estimativa** | **Tempo Real** | **Status** |
|:--------------|:----------------|:-----------------|:---------------|:---------------|:-----------|
| A3.1 | Estudar testes de aceitação em Grails | Todos| 2h | 4h  | C |
| A3.2 | Elaborar script de testes | Fabio | 1h | 30m | C |


---


## User Story 4 - Funcionalidade de login com privilégios ##

### Testes de Aceitação ###

  * Teste de Aceitação 4.1: Fazer login com usuário do tipo "administrador" (login com sucesso).
  * Teste de Aceitação 4.2: Fazer login com usuário do tipo "funcionario" (login com sucesso).
  * Teste de Aceitação 4.3: Fazer login com usuário do tipo "administrador" (login sem sucesso).
  * Teste de Aceitação 4.4: Fazer login com usuário do tipo "funcionario" (login sem sucesso).

**Artefatos Produzidos: [(Ver Observação)](http://code.google.com/p/neoclinica/source/browse/trunk/NeoClinicaTestes/README), [Testes de Aceitação](http://code.google.com/p/neoclinica/source/browse/trunk/NeoClinicaTestes/test/functional/LoginTests.groovy), [Estudo da Segurança em Grails](http://code.google.com/p/neoclinica/source/browse/trunk/neo/test/acceptance/us4/Relat%C3%B3rio%20Estudo%20de%20Seguran%C3%A7a%20em%20Grails.doc)**


### Atividades ###

| **Atividade** | **Descrição** | **Responsável** | **Estimativa** | **Tempo Real** | **Status** |
|:--------------|:----------------|:-----------------|:---------------|:---------------|:-----------|
| A4.1 | Estudar melhor alternativa de login em Grails | Solon | 3h | 2h30m | C |
| A4.2 | Implementar mecanismo de login | Solon | 2h | 1h30m| C  |


---


## User Story 14 - Elaborar Manual de Configuração do Sistema ##

### Testes de Aceitação ###

  * Teste de Aceitação 14.1: Manual do sistema. _Condição de sucesso: Instalar corretamente ambiente em máquina que não o tem instalado_.

**Artefatos Produzidos: [Manual de Deploy](http://code.google.com/p/neoclinica/source/browse/trunk/neo/test/acceptance/us14/ManualSistema.docx)**

### Atividades ###

| **Atividade** | **Descrição** | **Responsável** | **Estimativa** | **Tempo Real** | **Status** |
|:--------------|:----------------|:-----------------|:---------------|:---------------|:-----------|
| A14.1 | Fazer um manual de configuração do ambiente | Fabio | 1h | 1h17m | C |