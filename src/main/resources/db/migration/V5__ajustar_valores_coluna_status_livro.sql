UPDATE livro
set status_livro = 'PRE_VENDA'
where status_livro = '0';

UPDATE livro
set status_livro = 'VENDA'
where status_livro = '1';

UPDATE livro
set status_livro = 'COLECAO'
where status_livro = '2';

UPDATE livro
set status_livro = 'LOCACAO'
where status_livro = '3';