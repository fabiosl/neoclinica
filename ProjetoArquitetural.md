# Projeto Arquitetural #
![http://dl.dropbox.com/u/4330681/LES/Imagens/ScreenShot007.png](http://dl.dropbox.com/u/4330681/LES/Imagens/ScreenShot007.png)

## Descrição: ##
O sistema proposto para a disciplina será desenvolvido com base em uma arquitetura composta por três camadas. Essa arquitetura fará a separação das funcionalidades em camadas com o objetivo deixar independentes a **lógica de apresentação**, a **lógica de negócio** e a **lógica de acesso aos dados**.

A separação em três camadas tornará o sistema mais flexível, de modo que as partes possam ser alteradas independentemente. Dessa forma, qualquer alteração em uma determinada camada não influirá nas demais, desde que o mecanismo de comunicação entre elas permaneça inalterado.

O sistema, a princípio, será concebido para funcionar como uma aplicação _standalone_ em um servidor Web (_Apache Tomcat_), localizado fisicamente na clínica. Isso fará com que o mesmo possa ser executado tanto localmente, via intranet, como remotamente, via internet.

### Camada de Apresentação ###
A camada de apresentação será desenvolvida com auxílio do framework para desenvolvimento Web Grails{1} em sua versão 1.3.1. O framework em si já faz uso do padrão Model View Controller – MVC {2}, mas o projeto a ser desenvolvido fará uso principalmente das facilidades de Grails para o desenvolvimento de interface gráfica web. A geração do HTML{3} das páginas será feita via Groovy Server Pages – GSP{4]} e/ou Java Server Pages - JSP{5}.

### Camada de Negócio ###
A camada de negócio do sistema a ser desenvolvido também será feita usando a tecnologia Grails. A escolha de Grails, ao invés de outra qualquer, deu-se devido à experiência da equipe de desenvolvimento com a mesma e por Grails ser um framework Web para a linguagem Groovy, que roda em cima da plataforma Java{6}, que por sua vez possui grande número de ferramentas disponíveis que auxiliam o desenvolvimento, além de também ser familiar à todo o time.

### Camada de Dados ###
A persistência de dados do sistema será auxiliada pelo SGBD relacional MySQL{7}. A escolha do MySQL deu-se, principalmente, pelo fato de ser uma tecnologia de código aberto e não necessitar de licenças ou taxas para seu uso. Será adotado o padrão DAO{8} para realizar acesso ao banco de dados (ver [estudo](http://code.google.com/p/neoclinica/source/browse/trunk/neo/test/acceptance/us1/Padr%C3%A3o%20DAO.txt)). Para a modelagem das tabelas no banco de dados será utilizado o framework Hibernate{9}, que já é integrado ao framework Grails e faz o mapeamento automático das entidades para o mundo relacional.

### Tecnologias de Teste ###
Os testes de unidade serão realizados através do plugin nativo do framework Grails para testes de unidade - _Grails Unit Test Case_{10}. Os testes de aceitação serão realizados através dos testes de unidade Grails{10} (para testes relativos à lógica de négocio pura) e o plugin _Grails Functional Test_{11}, que permite fazer testes de aceitação através da análise do código de páginas HTML. Com uso deste plugin é possível aplicar os testes à interface, verificando restrições aplicadas um determinado tipo do usuário, uma vez que pode haver restrições de acesso à visões para usuários de determinados distintos. O plugin funciona como se fosse um web browser e funciona fazendo requisições HTTP e navegando entre páginas web.

| **Tipo de Teste** | **Unidade** | **Aceitação** | **Interface** |
|:------------------|:------------|:----------------|:--------------|
| **Tecnologia** | Grails Unit Test Case | Grails Unit Test Case + Grails Functional Test | Grails Functional Test |

## Referências Externas: ##
{1} - Grails Framework. http://grails.org/. Acesso em 31/08/2010

{2} - Model View Controller. http://www.dsc.ufcg.edu.br/~jacques/cursos/map/html/arqu/mvc/mvc.htm. Acesso em 31/08/2010.

{3} – HTML. http://pt.wikipedia.org/wiki/HTML. Acesso em 31/08/2010.

{4} -  Groovy Server Pages. http://en.wikipedia.org/wiki/Groovy_Server_Pages. Acesso em 31/08/2010.

{5} – Java Server Pages. http://java.sun.com/products/jsp/. Acesso em 31/08/2010.

{6} - Java. http://www.oracle.com/technetwork/java/index.html. Acesso em 31/08/2010.

{7} - SGBD MySQL. http://www.mysql.com/. Acesso em 31/08/2010.

{8} - Padrão DAO http://java.sun.com/blueprints/corej2eepatterns/Patterns/DataAccessObject.html. Acesso em 31/08/2010.

{9} - Hibernate http://www.dsc.ufcg.edu.br/~jacques/cursos/daca/html/hibernate/hibernate.htm. Acesso em 05/09/2010.

{10} - Testes de Unidade em Grails http://www.grails.org/Unit+Testing. Acesso em 20/09/2010.

{11} - Testes Funcionais em Grails http://grails.org/plugin/functional-test. Acesso em 20/09/2010.

_Obs.:_ As tecnologias de teste foram definidas na [iteração 1](http://code.google.com/p/neoclinica/wiki/PlanoIteracao1), user story 3.