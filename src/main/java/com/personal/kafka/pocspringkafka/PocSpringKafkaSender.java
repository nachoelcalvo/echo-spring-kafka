package com.personal.kafka.pocspringkafka;


import com.personal.kafka.pocspringkafka.domain.Echo;
import com.personal.kafka.pocspringkafka.service.EchoSenderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class PocSpringKafkaSender implements ApplicationRunner {

    @Autowired
    private EchoSenderService echoSenderService;


    @Override
    public void run(ApplicationArguments args) throws Exception {


        List<String> messages = Arrays.asList("Spring", "Kubernete", "git");

        Random position = new Random();

        Runnable runnable = () -> {
            echoSenderService.sendMessage(new Echo(messages.get(position.nextInt(messages.size()))));

        };
        Executors.newScheduledThreadPool(1).scheduleAtFixedRate(runnable, 1, 1, TimeUnit.SECONDS);
    }
}
