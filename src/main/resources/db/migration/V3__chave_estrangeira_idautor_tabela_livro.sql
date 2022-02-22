ALTER TABLE livro ADD CONSTRAINT fk_id_autor_livro
FOREIGN KEY (autor_id) REFERENCES autor(id);