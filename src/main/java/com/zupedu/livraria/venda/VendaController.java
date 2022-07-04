package com.zupedu.livraria.venda;

import com.zupedu.livraria.estoque.EstoqueRepository;
import com.zupedu.livraria.livro.LivroRepository;
import com.zupedu.livraria.notificacao.NotificacaoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    Logger logger = LoggerFactory.getLogger(VendaController.class);

    @Autowired
    private EstoqueRepository estoqueRepository;

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private NotificacaoService notificacaoService;

    @PostMapping
    public VendaResponse incluir(@RequestBody VendaRequest vendaRequest){
        var livro = livroRepository.findById(vendaRequest.getIdLivro())
                .orElseThrow(IllegalArgumentException::new);

        var estoque = estoqueRepository.findByLivro(livro)
                .orElseThrow(IllegalArgumentException::new);

        var venda = vendaRequest.toModel(livro, estoque);

        vendaRepository.save(venda);

        estoque.realizaBaixaEstoque();
        estoqueRepository.save(estoque);
        logger.info("Realizado Baixa no Estoque do Produto : {} , Quantidade : {} ",
                estoque.getLivro().getId(), estoque.getQuantidade());

        if(venda.realizaNotificacao()){
            logger.info("Enviando notificação de venda para o cliente : {} ", venda.getEmailCliente());
            notificacaoService.send(
                    venda.getEmailCliente(),
                    venda.getTituloNotificacao(),
                    venda.getMensagemNotificacao());
        }

        logger.info("Finalizando Venda ");
        return VendaResponse.from(venda);
    }
}
