## Configurando o MySQL para o projeto ##

_Só os passos que vão ser preciso para a equipe, já que a integração está feita no projeto_

|1|Baixar o MySQL server 5.1.50 (http://dev.mysql.com/downloads/mysql/5.1.html#downloads).|
|:|:--------------------------------------------------------------------------------------|
|2 |Instalar o MySQL. Eu deixei as opções padrão na instalação, next -> next -> next ...). A senha coloquem "r00tpa55". O login é "root" (padrão)|
|3 |Baixar o MySQL GUI (http://download.softagency.net/MySQL/Downloads/MySQLGUITools/mysql-gui-tools-5.0-r17-win32.msi) e instalar. |
|4 |Abre o MySQL Query Browser que vem no MySQL GUI, loga com root, e na barra lateral "Schemata", vai em "Create new schema". Criem o esquema "neo".|
|5 |Na primeira vez que for rodar o projeto, vai em grails-app/conf e abre DataSource.groovy; No bloco environments->development, muda a linha dbCreate =  "update" pra dbCreate = "create". Isso faz com que na hora de iniciar o projeto ele crie as tabelas no BD. Depois volta pra "update", se não ele vai fazer drop em todas as tabelas e perder os dados toda vez que iniciar.|

_Obs.:_ Esse artefato é resultado da US1.