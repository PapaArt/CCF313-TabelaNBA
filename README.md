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

### Criação da tabela
Após a criação dos times, criamos a classe TabelaNBA, em que incluímos uma lista de time com seus respectivos dados. 
Assim como na primeira classe, também foi implementada funções básicas como a addTime, getConferencia.
Feita a mudança para o MVC, criamos a classe TabelaDAO em que fizemos duas funções importantes, como a embates e a ordenaPosicao.


vale ressaltar que o objetivo inicial do projeto era imprimir duas tabelas, uma para a conferência leste e outra para a oeste
