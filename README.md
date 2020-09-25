# ProjetoTarefasTecWeb
CRUD de tarefas - Feito por Gabriel Kabbani

SCRIPT MYSQL:

USE db;
CREATE TABLE tarefas (id INT(2) NOT NULL PRIMARY KEY AUTO_INCREMENT, tarefa TEXT, prazo DATE, nivel INT(1), criador char(30);
CREATE TABLE login (usuario TEXT, senha TEXT);
INSERT INTO login (usuario, senha) VALUES ("Gabriel Kabbani", 1234);
INSERT INTO tarefas (tarefa, prazo, nivel, criador) VALUES ("Fazer projeto tecweb", "2020-09-25", 1, "Gabriel Kabbani");
INSERT INTO tarefas (tarefa, prazo, nivel, criador) VALUES ("Fazer projeto emptech", "2020-09-26", 2, "Gabriel Kabbani");
INSERT INTO tarefas (tarefa, prazo, nivel, criador) VALUES ("Estudar pra prova", "2020-10-25", 3, "Gabriel Kabbani");
