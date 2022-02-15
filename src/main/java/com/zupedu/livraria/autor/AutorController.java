package com.zupedu.livraria.autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorRepository repository;

    @PostMapping
    public AutorResponse incluir(@RequestBody AutorRequest request){
        var autor = repository.save(request.getAutor());

        return AutorResponse.of(autor);
    }
}
