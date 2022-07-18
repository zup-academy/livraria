package com.zupedu.livraria.venda;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class VendaProducer {

    Logger logger = LoggerFactory.getLogger(VendaProducer.class);

    @Value("${topic.name.producer}")
    private String topicName;

    @Autowired
    private KafkaTemplate<String, VendaEvento> kafkaTemplate;


    @Async
    public void send(Venda venda){
        VendaEvento evento = new VendaEvento();
        evento.setIdCompra(venda.getId());
        evento.setIdLivro(venda.getLivro().getId());
        evento.setValor(venda.getValor());

        logger.info("Evento gerado com sucesso");
        kafkaTemplate.send(topicName, evento);
    }
}
