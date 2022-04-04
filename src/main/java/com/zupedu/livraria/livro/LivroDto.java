package com.zupedu.livraria.livro;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zupedu.livraria.autor.AutorInexistenteException;
import com.zupedu.livraria.autor.AutorRepository;
import com.zupedu.livraria.categoria.CategoriaInexistenteException;
import com.zupedu.livraria.categoria.CategoriaRepository;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class LivroDto {

    private Long id;

    @NotBlank
    private String titulo;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataDeLancamento;

    private String resumo;

    private String idioma;

    private Long idCategoria;

    private Long idAutor;

    private FormatoEnum formato;

    private int paginas;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDateTime alterado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getDataDeLancamento() {
        return dataDeLancamento;
    }

    public void setDataDeLancamento(LocalDate dataDeLancamento) {
        this.dataDeLancamento = dataDeLancamento;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Long getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Long idAutor) {
        this.idAutor = idAutor;
    }

    public FormatoEnum getFormato() {
        return formato;
    }

    public void setFormato(FormatoEnum formato) {
        this.formato = formato;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public LocalDateTime getAlterado() {
        return alterado;
    }

    public void setAlterado(LocalDateTime alterado) {
        this.alterado = alterado;
    }

    public Livro getLivro(AutorRepository autorRepository, CategoriaRepository categoriaRepository) {
         var autor = autorRepository.findById(this.idAutor)
                 .orElseThrow(AutorInexistenteException::new);

         var categoria = categoriaRepository.findById(this.idCategoria)
                 .orElseThrow(CategoriaInexistenteException::new);

         return new Livro(this.titulo, this.dataDeLancamento, this.resumo,
                 this.idioma, categoria, autor, this.formato, this.paginas);
    }

    public LivroDto(Long id, String titulo, LocalDate dataDeLancamento, String resumo,
                    String idioma, Long idCategoria, Long idAutor, FormatoEnum formato,
                    int paginas, LocalDateTime alterado) {
        this.id = id;
        this.titulo = titulo;
        this.dataDeLancamento = dataDeLancamento;
        this.resumo = resumo;
        this.idioma = idioma;
        this.idCategoria = idCategoria;
        this.idAutor = idAutor;
        this.formato = formato;
        this.paginas = paginas;
        this.alterado = alterado;
    }

    public static LivroDto from(Livro livro) {
        return new LivroDto(livro.getId(), livro.getTitulo(), livro.getDataDeLancamento(),
                livro.getResumo(), livro.getIdioma(), livro.getCategoria().getId(),
                livro.getAutor().getId(), livro.getFormato(), livro.getPaginas(), livro.getAlterado());
    }
}
