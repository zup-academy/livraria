package com.zupedu.livraria.notificacao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Component;

@Component
public class NotificacaoListener {

    Logger logger = LoggerFactory.getLogger(NotificacaoListener.class);

    @SqsListener(value = "${cloud.aws.queue.name}", deletionPolicy = SqsMessageDeletionPolicy.NEVER)
    public void receber(Notificacao notificacao){

        logger.info("Mensagem recebida com sucesso: {}", notificacao.toString());
    }

}
