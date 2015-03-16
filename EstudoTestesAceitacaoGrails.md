# Introdução #
Como o nosso projeto da disciplina de Laboratório de Engenharia de Software faz uso do framework Grails, podemos ter os testes de aceitação sendo realizados tanto a nível de interface gráfica como a nível de classes de fachada, utilizando os frameworks existentes para testes de unidade.
Nosso projeto fará, sempre que possível, uso desses dois tipos de testes descritos anteriormente, para comprovar que a corretude do teste de unidade também aplica-se à interface do usuário.

# Estudo dos testes de aceitação a nível de interface gráfica #
Grails fornece aos desenvolvedores a possibilidade de acrescentar plugins aos projetos. Esses plugins podem prover, dentre outros benefícios, uma maior produtividade com relação ao código a ser desenvolvido e um alto nível de abstração para que os desenvolvedores preocupem-se em agregar valor ao sistema produzido ao invés de voltar os seus esforços para solucionar problemas internos do sistema de arquivos e afins.

No entanto, o framework Grails lança novas versões em um intervalo de tempo muito curto, fazendo com que os plugins que foram desenvolvidos pela comunidade tornem-se rapidamente obsoletos.

Atualmente o framework está na sua versão 1.3.4, mas, como descrevemos no projeto arquitetural usamos a versão 1.3.1 para desenvolver o projeto em questão.
Através de pesquisas pela internet achamos três possíveis plugins que poderiam auxiliar o desenvolvimento de testes de aceitação a nível de interface no nosso projeto. São eles:

•	Canoo Web Test Plugin; {1}

•	Stories; {2}

•	Functional-test Plugin. {3}

O Plugin Canoo Web Test atua como um Browser Web e permite que o usuários realize consultas ao HTML e navega entre os elementos de uma página através dos métodos GET e POST, do protocolo HTTP. No entanto, após muito esforço para fazer os testes através desse plugin, descobriu-se que o mesmo não é compatível com a versão de Grails que o grupo estava utilizando no projeto.

O Plugin Stories faz, basicamente, a organização de arquivos .groovy conforme um contexto para testes de funcionalidades, apresentando um espaço reservado para as atividades para serem realizadas antes e após cada história de uso contida no arquivo. O Plugin, por si só, não é capaz de realizar testes a nível de interface, sendo necessário, portanto fazer uso de outro plugin adicional para tal. Optou-se então, por escolher o plugin REST[4](4.md), que também atua como um browser Web fazendo as requisições necessárias para testar uma página HTML. No entanto, as operações que o plugin REST faziam não são suficientes para realizar os testes que o grupo necessita.

O plugin Functional-Tests também realiza testes de interface, do mesmo modo que o plugin Canoo Web Tests. Esse plugin nos pareceu ser o ideal para realizar os testes que eram necessários para checar a integridade e corretude do sistema a ser desenvolvido na disciplina. No entanto, novamente após muito esforço para realizar os testes, descobriu-se, novamente, que o plugin não era compatível com a versão que estava sendo utilizada no projeto.

É importante frizar que as informações de incompatibilidade dos plugins com as diversas versões de grails não é informada na página do plugin, sendo necessário que os testadores a descubram após erros inesperados do plugin.

O plugin Functional-Tests é compatível com a versão 1.1.1 de Grails, pois era a versão contemporânea ao seu lançamento. Decidimos, então, fazer com que os testes de aceitação a nível de interface fossem realizados em um segundo projeto, que é construído com base na versão 1.1.1 de Grails. Assim, para que o projeto NeoClinicaSI possa ser testado é necessário que o testador inicie primeiramente o servidor do mesmo e, após isso, execute os testes de aceitação através da linha de comando “grails test-app –functional” no projeto NeoClinicaTestes, que também está no Trunk do repositório principal.

# Referências Externas #
{1} Canoo Web Test Plugin - 	http://www.grails.org/plugin/webtest

{2} – Grails Stories Plugin - http://www.grails.org/plugin/grails-stories

{3} – Functional Tests Plugin - http://grails.org/plugin/functional-test

{4} – REST Plugin - http://www.grails.org/plugin/rest