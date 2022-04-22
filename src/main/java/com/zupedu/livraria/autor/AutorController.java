package com.zupedu.livraria.autor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/autores")
public class AutorController {

    Logger logger = LoggerFactory.getLogger(AutorController.class);

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping
    public ResponseEntity<?> inserir(@Valid @RequestBody AutorDto dto){
        var autor = dto.toModel();
        return salvar(autor, HttpStatus.CREATED);
    }

    private ResponseEntity<?> salvar(Autor autor, HttpStatus status) {
        if(autor.existeOutroAutorComMesmosDados(autorRepository)){
            return ResponseEntity.badRequest().body("Já existe autor com mesmo nome, nacionalidade e nascimento ");
        }else{
            autor = autorRepository.save(autor);

            logger.info("Autor cadastrado : {}", autor);

            return ResponseEntity
                    .status(status)
                    .body(AutorDto.from(autor));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluir(@PathVariable Long id){
        var autor = autorRepository.findById(id)
                .orElseThrow(AutorInexistenteException::new);

        autorRepository.delete(autor);

        logger.info("Autor {} excluido", autor);

        return  ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> alterar(@PathVariable Long id, @Valid @RequestBody AutorDto dto ){
        var autor = autorRepository.findById(id)
                .orElseThrow(AutorInexistenteException::new);

        autor.atualizaDados(dto);

        logger.info("Autor {} atualizado", autor);

        return salvar(autor, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> consultar(@PathVariable Long id){
        var autor = autorRepository.findById(id)
                .orElseThrow(AutorInexistenteException::new);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(AutorDto.from(autor));
    }

    @GetMapping
    public ResponseEntity<?> lista(){
        var autores = autorRepository.findAll();
        var autoresResponse = new ArrayList<AutorDto>();

        for (var autor:autores) {
            autoresResponse.add(AutorDto.from(autor));
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(autoresResponse);
    }

}
