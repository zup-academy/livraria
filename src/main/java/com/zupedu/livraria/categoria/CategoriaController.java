package com.zupedu.livraria.categoria;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.http.HttpResponse;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    Logger logger = LoggerFactory.getLogger(CategoriaController.class);

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping("/categorias")
    public ResponseEntity<?> inserir(@Valid @RequestBody CategoriaDto request){

        if(categoriaRepository.findByNome(request.getNome()).isPresent()){
            logger.info("Não foi possível cadastrar nova categoria, pois já existe uma categoria com esse nome");
            return ResponseEntity.badRequest().body("Já existe categoria cadastrada com esse nome");
        }else{
            var categoria = categoriaRepository.save(request.getCategoria());

            logger.info("Categoria cadastrada com sucesso");

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
