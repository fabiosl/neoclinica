# Introdução #

A versão em _.doc_ do relatório pode ser encontrada no seguinte [link](http://neoclinica.googlecode.com/svn/trunk/neo/test/acceptance/us4/Relatório%20Estudo%20de%20Segurança%20em%20Grails.doc). O texto pode ser visto abaixo.


# Relatório #

  * **Contexto e Problema**
As principais questões relacionadas a segurança em sistemas Grails são o controle do acesso às páginas pelos diferentes usuários e o próprio acesso ao sistema. Nesse sentido, controle de acesso é entendido como acesso a dados que são sigilosos para determinada categoria de usuário. Para o sistema proposto no projeto, existem duas hierarquias básicas: médico e funcionário. De acordo com as especificações do cliente, um médico deve ter acesso a todas as funcionalidades do sistema, enquanto um funcionário não deve ter informações sobre as questões de controle de estoque e movimentação financeira, por exemplo. Obviamente, só os usuários do tipo médico quem poderão realizar o cadastro de outros usuários, sejam eles outros médicos ou funcionários.
Para lidar com questões como essa, é necessário que o sistema restrinja o acesso a determinadas páginas. É preciso ter o controle de quem acessa o que no sistema. Esse controle não deverá ser feito na view  (já que Grails utiliza padrão MVC), pois esse tipo de alternativa não é escalável e provoca alto acoplamento do código.
Em resumo, precisa-se de alternativas para tratar questões de autenticação e autorização de usuários. Sendo assim, o estudo de uma maneira eficaz de realizar esse controle  é fundamental o funcionamento adequado de todo o projeto

  * **Solução**
Em busca da melhor maneira de lidar com uma solução para esse problema, buscou-se alternativas que atendessem os desejos do cliente e da equipe. As pesquisas foram realizadas em revistas especializadas; internet e livros sobre programação em Grails como o _Grails in Action_ e _Beginning Groovy and Grails - From Novice to Professional_.
Tais pesquisas mostraram várias alternativas para essa questão. Algumas combinavam uso de mais de um plugin, outras o faziam apenas com um único. Diante desse cenário, a escolha do plugin SpringSecurity, também conhecido como Acegi mostrou-se a mais completa e confiável. Ele disponibilizava tudo que se desejava de maneira simples e já bastante difundida na comunidade Grails.

  * **Funcionamento**
O funcionamento do plugin de segurança escolhido é um pouco complexo, pois envolve desde autenticação até autorização de acesso, mas será explicado por cima. Em suma, o que é feito é a criação de diferentes níveis de hierarquia que são atribuídos a contas de usuários aliados a um sistema poderoso de login.
Feito isso, é preciso: estabelecer condições de que, com o objetivo de utilizar o sistema, os usuários devem sempre estar logados e que cada página do sistema tenha controle de acesso. Isso é feito estabelecendo-se um mapeamento de página para nível de hierarquia. Assim, antes de possibilitar acesso a alguma página, o sistema verifica se o usuário tem acesso para tal. Se não tiver, ele é direcionado para outro lugar. Caso o tenha, ele prossegue na navegação.
Todas as verificações são feitas automaticamente pelo plugin Acegi. A cargo dos desenvolvedores fica apenas o processo de criar e setar as hierarquias e o mapeamento às páginas (o cadastramento de usuários é feito por usuários autenticados para isso). Todo o processo é feito tanto através de controladoras, como através da definição de parâmetros nas classes de controle. A **Figura 0** faz um resumo do funcionamento do plugin.

![http://neoclinica.googlecode.com/svn/trunk/neo/test/acceptance/us4/figura.jpg](http://neoclinica.googlecode.com/svn/trunk/neo/test/acceptance/us4/figura.jpg)

