package com.zupedu.livraria.notificacao;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.http.MediaType;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

@Service
public class NotificacaoService {

    Logger logger = LoggerFactory.getLogger(NotificacaoService.class);

    private Gson gson = new Gson();

    @Value("${cloud.aws.queue.name}")
    private String queue;

    @Autowired
    private QueueMessagingTemplate messagingTemplate;

    private void send(final Notificacao notificacao) {
//        Message<Notificacao> mensagem = MessageBuilder.withPayload(notificacao)
//                .setHeader(MessageHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();

//        Map<String, Object> headers = new HashMap<>();
//        headers.put(MessageHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

        messagingTemplate.convertAndSend(queue, notificacao);

        logger.info("Mensagem enviada : {}", notificacao.getMessage());
    }

    @Async
    public void send(String email, String titulo, String mensagem){
        Notificacao notificacao = new Notificacao(email, "EMAIL", titulo, mensagem);

        send(notificacao);
    }
}
