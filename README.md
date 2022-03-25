# CCF313-TabelaNBA

## Vinicius Mendes - 3881 e Artur Papa - 3886
### Descrição do projeto
O projeto em questão visa proporcionar uma experiência única para o usuário, visto que, foi desenvolvido com o objetivo de poder ser utilizado como catálogo de resultados, além de um gerenciador de jogos amadores.

Existem três modos, um especialmente para acompanhamento dos jogos, possuindo uma metodologia de consulta a um banco de dados, que neste caso, contém dados da tabela, outro para a criação de um campeonato "fantasy" em que o usuário irá criar uma tabela local, porém seguindo as mesmas regras de divisão e conferência do campeonato oficial e, por fim, a visualização do desempenho de alguns jogadores que marcaram a história na NBA e outros que ainda jogam o campeonato.
  
<img align="center" alt="Jordan" height="200" width="200" src="https://cdn.discordapp.com/attachments/885924523025780760/922232630987087932/basketball-player.png">

### Criação dos times
Primeiramente foi criado a classe para os times em que incluímos as funções mais básicas como a getJogos, getDivisao, posicaoTabela e setVitoria.
Conforme avançávamos no projeto adicionamos mais atributos, como a divisão e a conferência.
Feita a mudança para o MVC, criamos o TimeDAO que implementava funções para pegar a divisão, conferência e o id de determinado time da lista de times. 

<img align="center" alt="construtorTime" height="230" width="802" src="https://cdn.discordapp.com/attachments/885924523025780760/956744862504472666/Captura_de_tela_de_2022-03-24_23-42-02.png">

### Criação da tabela
Após a criação dos times, criamos a classe TabelaNBA, em que incluímos uma lista de time com seus respectivos dados. 
Assim como na primeira classe, também foi implementada funções básicas como a addTime, getConferencia.
Feita a mudança para o MVC, criamos a classe TabelaDAO em que fizemos duas funções importantes, como a embates e a ordenaPosicao.
A primeira foi criada com o intuito de realizar os embates de cada time para a criação da tabela feita pelo usuário.
Já a segunda tem por objetivo ordenar a posição dos times na lista, seja com os dados retirados do banco ou criados localmente.

Vale ressaltar que o objetivo inicial do projeto era imprimir duas tabelas, uma para a conferência leste e outra para a oeste, porém, com o desenrolar do projeto resolvemos por deixar todos os times em um só quadro, utilizando das enumerações da conferência e divisão apenas no cálculo das funções. Dessa maneira, temos que os times na posição de 0 a 14 são referentes a conferência leste e das posições restantes referentes a conferência oeste.

Por fim, é válido dizer que a classificação é ordenada pela porcentagem de vitória e em caso de empate é analisado os pontos por jogo.

### Banco de dados
A realização do projeto se fez possível através da utilização de um banco de dados criado por nós mesmos. Buscamos outras formas de realizar as inserções no algoritmo, entretanto não obtivemos um resultado que nos agradasse. A partir disso, criamos uma "schedule" chamada NBA, que possui uma tabelaTimes,jogadores e anoTabela.

A primeira, possui os mesmos parâmetros de criação vistos no construtor de Time, citado acima. A segunda, o construtor dos jogadores e a terceira é responsável por indicar o período que a tabela representa.

<img align="center" alt="bancoTime" height="230" width="400" src="https://cdn.discordapp.com/attachments/885924523025780760/956747485735448606/Captura_de_tela_de_2022-03-24_23-50-53.png">


Foi desenvolvido no MySQL versão 8.0.25 build 788958.

Para execução do projeto, é necessário utilizar o banco de dados, alterar o caminho JDBC nos locais em que há a leitura do banco, sendo eles na telaTabela e jogadorDAOmysql
# Padrão: 
## jdbc:mysql://127.0.0.1:3306/nba", "root", "password");


### Jogadores

Diferentemente dos times e da tabela a classe para os jogadores foi criada apenas com o intuito estatístico e não há nenhuma inserção de dados vindo do usuário.

Sendo assim, teremos apenas os dados de pontuações para os jogadores e outros atributos como
