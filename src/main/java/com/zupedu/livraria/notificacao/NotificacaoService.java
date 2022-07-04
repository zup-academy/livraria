package com.zupedu.livraria.notificacao;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class NotificacaoService {

    Logger logger = LoggerFactory.getLogger(NotificacaoService.class);

    private Gson gson = new Gson();

    @Value("${cloud.aws.queue.name}")
    private String queue;

    @Autowired
    private QueueMessagingTemplate messagingTemplate;

    private void send(final String messagePayload) {

        Message<String> mensagem = MessageBuilder.withPayload(messagePayload).build();

        messagingTemplate.convertAndSend(queue, mensagem);

        logger.info("Mensagem enviada : {}", messagePayload);
    }

    @Async
    public void send(String email, String titulo, String mensagem){
        Notificacao notificacao = new Notificacao(email, "EMAIL", titulo, mensagem);

        String message = gson.toJson(notificacao);
        send(message);
    }
}
