CREATE TABLE autor (
  id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  nome varchar(120),
  email varchar(120),
  data_nascimento timestamp,
  biografia varchar(300),
  criado timestamp
);
