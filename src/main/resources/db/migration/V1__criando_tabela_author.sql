CREATE TABLE `autor` (
  `id` bigint NOT NULL primary key ,
  `nome` varchar(120),
  `email` varchar(120),
  `dataNascimento` timestamp,
  `biografia` varchar(300),
  `criado` timestamp
);