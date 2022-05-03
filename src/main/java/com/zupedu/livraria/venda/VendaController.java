package com.zupedu.livraria.venda;

import com.zupedu.livraria.estoque.EstoqueRepository;
import com.zupedu.livraria.livro.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    private EstoqueRepository estoqueRepository;

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private VendaRepository vendaRepository;


    @PostMapping
    public VendaResponse incluir(@RequestBody VendaRequest vendaRequest){
        var venda = vendaRequest.toModel(livroRepository, estoqueRepository);

        vendaRepository.save(venda);

        return VendaResponse.from(venda);
    }

}
