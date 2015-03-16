# Documento de Visão #

### SI NEO ###

**Descrição**

A clínica Núcleo Especializado em Oftalmologia (NEO), fundada em  2003, está localizada na cidade de Campina Grande e atende pacientes de Campina Grande e região. As consultas realizadas estão ligadas a serviços oftalmológicos. Atualmente dois médicos atendem na clínica e o corpo de funcionários é formado por três secretárias.

Os serviços realizados na clínica vão desde o agendamento de consultas para pacientes até a venda e  pedido de lentes oftalmológicas junto aos fornecedores. Para esses e outros pedidos, tanto pacientes quanto lentes e fornecedores são cadastrados em um banco de dados e todas transações são registradas. Atualmente parte desse processo é feita manualmente em fichas de papel e planilhas eletrônicas, o que dificulta muito a agilidade do processo; o conhecimento do andamento dos pedidos e o acompanhamento, por parte dos médicos, do controle do estoque e do caixa é lento pois depende da análise manual das planilhas por parte das responsáveis.

Diante disso, percebe-se que um sistema de informação que agilize esse processo ajudará fortemente o trabalho dos envolvidos. Ele fará com que as informações sejam acessadas de maneira mais eficiente e precisa por todos a qualquer momento. Fará ainda com que se tenha maior controle tanto no atendimento aos clientes quanto no contato com os fornecedores e no controle do estoque.

A infra-estrutura computacional da clínica conta com 3 máquinas e disponibilidade de compra de mais uma. Um dos computadores está localizado na recepção, outro na sala de atendimento das consultas e o terceiro fica em uma outra sala isolada. Todos esses computadores serão ligados em rede, e dessa forma é desejável que o sistema possa ser acionado de qualquer um dessas máquinas mediante autenticação de usuários.

Percebe-se, então, que o sistema é formado, em suma, por dois componentes: **controle financeiro** e **agenda médica**. O _Controle Financeiro_ é o componente de maior prioridade, responsável tanto por prover interfaces de **cadastro, atualização, remoção e consulta** dos dados relevantes (cadastro de pacientes, fornecedores, médicos, vendas de lentes, procedimentos médicos, estoque, etc.) quanto fornecer informações detalhadas sobre o balanço financeiro da clínica. Já a _Agenda Médica_ é um componente que deve possibilitar aos usuários consultas às atividades dos médicos em datas específicas. A agenda é um componente de menor prioridade pois já é controlada por outra aplicação, embora torne-se necessária pelo fato dos médicos desejarem ver sua agenda de diversos lugares - funcionalidade que essa aplicação utilizada hoje não fornece por ser _desktop_.

Cada um desses componentes iniciais pode ser decomposto, ao longo do processo, em componentes menores de acordo com eventuais necessidades que surgirem.

**Requisitos Funcionais**

  * _1. Componente: Controle financeiro_
    * a. Gerenciamento de Pacientes;
    * b. Gerenciamento de Usuários (Médicos e Funcionários);
    * c. Gerenciamento de Lentes (Pedidos e Cadastro de Fornecedores);
    * d. Gerenciamento de Procedimentos médicos;
    * e. Emissão de relatórios financeiros;
    * f. Emissão de relatórios de estoque;

  * _2. Componente: Agenda médica_
    * a. Consulta à agenda do médico por data;
    * b. Busca de dados dos pacientes com consultas por realizar.

**Requisitos não-funcionais**

  * 1. Banco de dados relacional com o SGBD MySQL;
  * 2. Uso de login com níveis de acesso distintos(Administrador/Funcionários);
  * 3. Interface web;
  * 4. Uso de padrões de projeto;
  * 5. Segurança com os dados;
  * 6. Integridade dos dados.

**Perfil do Usuário**

O sistema será usado diariamente de forma direta por funcionários e médicos da clínica. Essas pessoas estão na faixa etária dos 30 anos de idade. Os usuários serão pessoas que já têm experiência com computadores e sistemas informatizados seja por utilizarem outros sistemas na própria clínica e em outros locais de trabalho ou por serem capacitados através de cursos.

Os pacientes interagirão com o sistema por intermédio dos funcionários e médicos. Esses últimos serão os responsáveis por passar para o sistema todos as informações necessárias. Dessa forma, não serão necessárias, a princípio, preocupações relativas a treinamento de usuários totalmente despreparados no uso de computadores.