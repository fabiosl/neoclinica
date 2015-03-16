## Modelo de Dados ##
<img src='http://neoclinica.googlecode.com/svn/trunk/documentos/modeloDeDados/Modelo de Dados.jpg'>

O modelo de dados esboçado acima baseia-se nas informações obtidas nas primeiras reuniões com o cliente e nas tabelas fornecidas pelos usuários do sistema. Atualmente, o controle financeiro é feito através de planilhas do Microsoft Excel.<br>
<br>
Nesse modelo estão as entidades que de fato serão armazenadas no banco de dados para realização das user stories descritas pelo cliente.<br>
<br>
<i>Obs.:</i> O "idExterno" é um dado relativo ao sistema em uso na clínica (PersonalMed).<br>
<br>
<i>Obs 2.:</i> Houveram algumas alterações menores no modelo sugeridas pelo monitor (troca de uma agregação por associação) e foi removida a hierarquia de classes para procedimento médico, mudança solicitada na validação do modelo na <a href='http://code.google.com/p/neoclinica/wiki/AtaReunioes'>reunião 5</a> (pois os procedimentos são flexíveis e deve ser possível cadastrar um novo tipo quando preciso).