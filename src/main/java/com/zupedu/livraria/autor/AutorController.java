package com.zupedu.livraria.autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorRepository repository;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public AutorResponse incluir(@RequestBody AutorRequest request){
        var autor = repository.save(request.getAutor());

        return AutorResponse.of(autor);
    }
}
