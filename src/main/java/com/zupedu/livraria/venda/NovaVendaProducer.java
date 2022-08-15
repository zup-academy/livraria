package com.zupedu.livraria.venda;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class NovaVendaProducer {

    Logger logger = LoggerFactory.getLogger(NovaVendaProducer.class);

    @Value("${spring.kafka.producer.topic}")
    private String topic;

    @Autowired
    private KafkaTemplate<String, NovaVendaEvent> kafkaTemplate;


    @Async
    public void send(Venda venda){
        NovaVendaEvent evento = new NovaVendaEvent(venda);

        kafkaTemplate.send(topic, evento);

        logger.info("Evento de NOVA VENDA gerado com sucesso : {} ", evento.toString());
    }

}
