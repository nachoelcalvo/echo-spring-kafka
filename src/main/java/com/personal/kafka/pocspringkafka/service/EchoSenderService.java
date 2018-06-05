package com.personal.kafka.pocspringkafka.service;


import com.personal.kafka.pocspringkafka.domain.Echo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EchoSenderService {

    @Autowired
    private KafkaTemplate<String, Echo> kafkaTemplate;

    @Value("${topic.echo}")
    private String topic;


    public void sendMessage(Echo message){
        kafkaTemplate.send(topic, message);
        log.info("Message Sent " + message.getMessage());
    }
}
