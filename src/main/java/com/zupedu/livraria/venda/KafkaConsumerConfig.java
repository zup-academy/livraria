package com.zupedu.livraria.venda;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

//@Configuration
public class KafkaConsumerConfig {
//    @Value(value = "${spring.kafka.producer.bootstrap-servers}")
//    private String bootstrapAddress;
//
//    @Value(value = "${spring.kafka.consumer.group-id}")
//    private String groupId;
//
//    public ConsumerFactory<String, VendaEvento> vendaConsumerFactory() {
//        Map<String, Object> props = new HashMap<>();
//        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
//        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
//        props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
//        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, )
//        return new DefaultKafkaConsumerFactory<>(props);
//    }
//
//
//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<String, VendaEvento> vendaKafkaListenerContainerFactory() {
//        ConcurrentKafkaListenerContainerFactory<String, VendaEvento> factory = new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(vendaConsumerFactory());
//        factory.setMessageConverter(new StringJsonMessageConverter());
//        return factory;
//    }

}
