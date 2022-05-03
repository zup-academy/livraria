package com.zupedu.livraria.estoque;

import com.zupedu.livraria.livro.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {

    @Autowired
    private EstoqueRepository estoqueRepository;

    @Autowired
    private LivroRepository livroRepository;

    @PostMapping()
    public EstoqueResponse incluir(@RequestBody EstoqueRequest request){

        var estoque = request.toModel(livroRepository);

        if(estoqueRepository.findByLivro(estoque.getLivro()).isPresent()){
            throw new IllegalArgumentException("Já existe estoque para este livro, por favor faça atualização dele.");
        }

        estoqueRepository.save(estoque);

        return EstoqueResponse.from(estoque);
    }

    @PutMapping("/{id}")
    public EstoqueResponse atualizar(@RequestBody EstoqueRequest request,
                                     @PathVariable Long id){

        var estoque = estoqueRepository.findById(id)
                .orElseThrow(EstoqueInexistente::new);

        estoque.atualizaEstoque(request.getQuantidade(), request.getValorUnitario());

        estoqueRepository.save(estoque);

        return EstoqueResponse.from(estoque);
    }

}
