package com.zupedu.livraria.categoria;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    Logger logger = LoggerFactory.getLogger(CategoriaController.class);

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    public ResponseEntity<?> inserir(@Valid @RequestBody CategoriaDto request){

        if(categoriaRepository.findByNome(request.getNome()).isPresent()){
            logger.warn("Categoria {} não pode ser cadastrada pois já existe na base de dados",request.getNome());
            return ResponseEntity.badRequest().body("Já existe categoria cadastrada com esse nome");
        }else{
            var categoria = categoriaRepository.save(request.toModel());

            logger.info("Categoria {} cadastrada com sucesso", categoria.getNome());
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(CategoriaDto.from(categoria));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluir(@PathVariable Long id){

        var categoria = categoriaRepository.findById(id)
                .orElseThrow(CategoriaInexistenteException::new);

        categoriaRepository.delete(categoria);

        return  ResponseEntity.ok().build();
    }

}
