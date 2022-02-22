CREATE TABLE livro (
  id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  titulo varchar(120) NOT NULL,
  valor double ,
  numero_paginas int,
  isbn int,
  data_publicacao timestamp,
  autor_id bigint,
  data_criacao timestamp,
  foreign key (autor_id) references autor(id)
);
