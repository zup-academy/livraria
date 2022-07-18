package com.zupedu.livraria.venda;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class VendaConsumer {

    Logger logger = LoggerFactory.getLogger(VendaConsumer.class);

    @Value("${topic.name.consumer}")
    private String topicName;

    @KafkaListener(topics = "${topic.name.consumer}", groupId = "livraria")
    public void consume( VendaEvento payload){
//        logger.info("key: {}", payload.key());
//        logger.info("Headers: {}", payload.headers());
//        logger.info("Partion: {}", payload.partition());
//        logger.info("Order: {}", payload.value());

        logger.info("Evento lido com sucesso idCompra: {}", payload.getIdCompra());
    }
}
