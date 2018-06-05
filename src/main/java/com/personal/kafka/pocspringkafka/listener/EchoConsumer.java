package com.personal.kafka.pocspringkafka.listener;

import com.personal.kafka.pocspringkafka.domain.Echo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EchoConsumer {

    @KafkaListener(topics = "topic-echo-message")
    public void listen(Echo message){
      log.info("Message received " + message.getMessage());
    }
}
