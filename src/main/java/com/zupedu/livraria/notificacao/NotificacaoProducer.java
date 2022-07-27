package com.zupedu.livraria.notificacao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class NotificacaoProducer {

    Logger logger = LoggerFactory.getLogger(NotificacaoProducer.class);

    @Value("${cloud.aws.queue.name}")
    private String queue;

    @Autowired
    private QueueMessagingTemplate messagingTemplate;

    private void send(final Notificacao notificacao) {

        messagingTemplate.convertAndSend(queue, notificacao.toString());

        logger.info("Mensagem enviada : {}", notificacao.getMessage());
    }

    @Async
    public void send(String email, String titulo, String mensagem){
        Notificacao notificacao = new Notificacao(email, "EMAIL", titulo, mensagem);

        send(notificacao);
    }
}
