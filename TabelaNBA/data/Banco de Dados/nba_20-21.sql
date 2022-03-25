-- TEMPORADA 20-21 --

CREATE SCHEMA IF NOT EXISTS nba;

USE nba;

CREATE TABLE IF NOT EXISTS anoTabela(
	periodo VARCHAR(20) NOT NULL,
    PRIMARY KEY (periodo)
);

CREATE TABLE IF NOT EXISTS times
(
    idTime INT NOT NULL,
    nomeTime VARCHAR(45) NOT NULL,
    vitorias INT NOT NULL,
    derrotas INT NOT NULL,
    jogos INT NOT NULL,
    pontosPorJogo DOUBLE NOT NULL,
    posicao INT NOT NULL,
    conf VARCHAR(20) NOT NULL,
    divi VARCHAR(20) NOT NULL,
    periodo VARCHAR(20) NOT NULL,
    PRIMARY KEY (idTime),
    FOREIGN KEY (periodo) REFERENCES anoTabela(periodo)
);

CREATE TABLE IF NOT EXISTS jogadores
(
	idPlayer INT NOT NULL,
    nomeJogador VARCHAR(30) NOT NULL,
    altura DOUBLE,
    peso DOUBLE,
    PPG	DOUBLE,
    RPG	DOUBLE,
    APG DOUBLE,
    trueShooting DOUBLE,
    allStar	INT,
    MVP	INT,
    finalMVP INT,
    titulosNBA	INT,
    PRIMARY KEY (idPlayer)
);

INSERT INTO anoTabela(periodo)
VALUES('2020/2021');


INSERT INTO times(idTime, nomeTime, vitorias, derrotas, jogos, pontosPorJogo, posicao, conf, divi, periodo)
VALUES(0,'Brooklyn Nets',48,24,72,118.6,2,'LESTE','ATLANTICO', '2020/2021'),
(1,'Boston Celtics',36,36,72,112.6,4,'LESTE','ATLANTICO', '2020/2021'),
(2,'Philadelphia 76ers',49,23,72,113.6,1,'LESTE','ATLANTICO', '2020/2021'),
(3,'Toronto Raptors',27,45,72,111.3,5,'LESTE','ATLANTICO', '2020/2021'),
(4,'New York Knicks',41,31,72,107.0,3,'LESTE','ATLANTICO', '2020/2021'),

(5,'Cleveland Cavaliers',22,50,72,103.8,4,'LESTE','CENTRAL', '2020/2021'),
(6,'Indiana Pacers',41,31,72,115.3,2,'LESTE','CENTRAL', '2020/2021'),
(7,'Detroid Pistons',41,31,72,106.6,5,'LESTE','CENTRAL', '2020/2021'),
(8,'Chicago Bulls',41,31,72,110.5,3,'LESTE','CENTRAL', '2020/2021'),
(9,'Milwaukee Bucks',41,31,72,120.1,1,'LESTE','CENTRAL', '2020/2021'),

(10,'Charlotte Hornets',33,39,72,109.5,4,'LESTE','SUDESTE', '2020/2021'),
(11,'Miami Heat',40,32,72,108.1,2,'LESTE','SUDESTE', '2020/2021'),
(12,'Atlanta Hawks',41,31,72,113.7,1,'LESTE','SUDESTE', '2020/2021'),
(13,'Washington Wizards',34,38,72,116.6,3,'LESTE','SUDESTE', '2020/2021'),
(14,'Orlando Magic',21,51,72,104.0,5,'LESTE','SUDESTE', '2020/2021'),

(15,'Utah Jazz',52,20,72,116.4,1,'OESTE','NOROESTE', '2020/2021'),
(16,'Denver Nuggets',47,35,72,115.1,2,'OESTE','NOROESTE', '2020/2021'),
(17,'Minnesota Timberwolves',23,49,72,112.1,4,'OESTE','NOROESTE', '2020/2021'),
(18,'Portland Trail Blazers',42,30,72,116.1,3,'OESTE','NOROESTE', '2020/2021'),
(19,'Oklahoma City Thunder',22,50,72,105.0,5,'OESTE','NOROESTE', '2020/2021'),

(20,'Phoenix Suns',51,21,72,115.3,1,'OESTE','PACIFICO', '2020/2021'),
(21,'Golden State Warriors',39,33,72,112.7,4,'OESTE','PACIFICO', '2020/2021'),
(22,'Los Angeles Clippers',47,25,72,114.0,2,'OESTE','PACIFICO', '2020/2021'),
(23,'Los Angeles Lakers',42,30,72,109.5,3,'OESTE','PACIFICO', '2020/2021'),
(24,'Sacramento Kings',31,41,72,113.7,5,'OESTE','PACIFICO', '2020/2021'),

(25,'Memphis Grizzlies',38,34,72,113.3,2,'OESTE','SUDOESTE', '2020/2021'),
(26,'Dallas Mavericks',42,30,72,112.4,1,'OESTE','SUDOESTE', '2020/2021'),
(27,'New Orleans Pelicans',31,41,72,114.6,4,'OESTE','SUDOESTE', '2020/2021'),
(28,'San Antonio Spurs',33,39,72,111.1,3,'OESTE','SUDOESTE', '2020/2021'),
(29,'Houston Rockets',17,55,72,108.8,5,'OESTE','SUDOESTE', '2020/2021');

INSERT INTO jogadores
VALUES	(0, 'Michael Jordan', 1.98, 97.97, 30.1, 6.2, 5.3, 56.9, 14, 5, 6, 6),
		(1, 'LeBron James', 2.06, 113.4, 27.1, 7.5, 7.4, 61.7, 17, 4, 4, 4),
        (2, 'Ja Morant', 1.91, 79, 21.2, 7.1, 4.5, 57.5, 0, 0, 0, 0),
        (3, 'Nikola Jokic', 2.11, 129, 19.4, 10.3, 6.2, 65.3, 3, 1, 0, 0),
        (4, 'Kareem Abdul-Jabbar', 2.18, 102, 24.6, 11.2, 2.6, 55.9, 19, 6, 2, 6);
        