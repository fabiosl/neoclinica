# Test Review #

O Test Review no sistema consistirá nas seguintes etapas (_cada uma será discutida mais afundo_) não necessariamente disjuntas:
  * Unificação dos Testes de Integração;
  * Revisão dos Testes de Integração;
  * Revisão dos Testes de Unidade.

## Unificação dos Testes de Integração (_Status: Concluído_) ##
Os Testes de Integração da [Iteração 1](http://code.google.com/p/neoclinica/wiki/PlanoIteracao1) e da [Iteração 2](http://code.google.com/p/neoclinica/wiki/PlanoIteracao1) faziam uso de um plugin chamado FunctionalTest Plugin. Por questões de incompatibilidade com e versão do framework grails utilizada até então, tínhamos que utilizá-lo em um projeto à parte para que ele pudesse fazer os testes de maneira adequada. Essa atividade, ao nosso modo de enxergar, era onerosa e trazia alguns empecilhos para a atividade de testes. Dessa forma, continuamos buscando melhor alternativa para elaboração dos Testes de Integração que foi encontrada através da extensão da classe GroovyTestCase. Essa alternativa nos possibilitou criar e rodar Testes de Integração de uma maneira mais direta e precisa. Sendo assim, essa alternativa foi a utilizada durante as demais iterações. Com o desenrrolar do projeto, não houve tempo efetivo para trazer aqueles testes da _Iteração 1_ e da _Iteração 2_ para o plugin atual. Logo, uma das principais atividades da etapa de Test Review será a adequação daqueles casos de testes do plugin FunctionalTest para o plugin atual.

### Resultados ###
O primeiro passo foi a checagem da viabilidade para realização da transição dos casos de teste. Essa checagem foi necessária porque alguns dos testes realizados pelo plugin anterior eram testes baseados na interface, logo lidavam com componentes que não são levados em consideração no novo plugin, que tem sua base apenas na escrita de códigos de teste sem preocupação com questões de interface. Como resultado, foram criados dois novos casos de teste e apenas um ficou com o plugin antigo, que foi o teste da funcionalidade de login, pois essa é controlada por um plugin externo usado no programa, então o teste via interface tornou-se menos elaborado e mais eficaz para os propósitos. Em números:

| Classes de teste alteradas | Classes de testes adicionadas | Erros encontrados | Casos de teste adicionados |
|:---------------------------|:------------------------------|:------------------|:---------------------------|
|0 |2 |0 |9 |

## Revisão dos Testes de Integração (_Status: Concluído_) ##
A atividade de Revisão dos Testes de Integração é uma atividade que será como objetivo de dar maior segurança de que os casos de testes existentes têm a maior cobertura possível. Buscaremos atingir essa métrica com a elaboração de casos que cobrem a maior parte das situações possíveis que podem existir à medida que um usuário externo lida com o sistema.

### Resultados ###
A atividade de test review para os testes de integração já existentes se deu basicamente para adição de novos casos de teste. Não foi criado nenhum método de teste novo, mas os já existentes foram incrementados com adição de novos testes que pudessem deixá-los ainda mais ricos. Os testes existentes até então exerciam o que se propunham de maneira adequada, mas pequenos detalhes ainda faltavam ser testados. Esses detalhes foram avaliados mediante novos casos adicionados criteriosamente escolhidos. Nenhum erro foi encontrado tanto nos testes antigos quanto no sistema após a adição dos novos casos de teste. O números resultantes da atividade de test review podem ser vistos na tabela abaixo.

| Classes de teste alteradas | Classes de testes adicionadas | Erros encontrados | Casos de teste adicionados |
|:---------------------------|:------------------------------|:------------------|:---------------------------|
|3 |0 |0 |26|

## Revisão dos Testes de Unidade (_Status: Concluído_) ##
Igualmente aos Testes de Integração, os Testes de Unidade existentes também devem ser revisados. A diferença, entretanto, é que essa atividade é bem mais simples e direta já que as classes existentes no sistema têm poucos métodos (Como se usa grails, as classes são classes de domínio, que apenas têm atributos). Serão apenas verificados se todos os métodos são testados (em sua maioria _get's_ e _set's_ implementados pelo próprio framework Grails) e se eles se os testes apresentam cobertura suficiente. Caso seja considerado insuficiente, novos testes serão elaborados.

### Resultados ###
O test review dos testes de unidade teve como principal resultado a adição de casos de teste que testavam novos métodos que não tinham sido testados antes. Em poucos casos, tivemos que alterar algum teste já existente. Como resultado do test review, foi encontrado apenas uma falta no código. Essa falta foi prontamente corrigida na implementação e todos os testes funcionaram corretamente. Em números:
| Classes de teste alteradas | Classes de testes adicionadas | Erros encontrados | Casos de teste adicionados |
|:---------------------------|:------------------------------|:------------------|:---------------------------|
|12| 0 | 1 | 4 |