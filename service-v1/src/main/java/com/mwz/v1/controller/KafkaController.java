package com.mwz.v1.controller;

import com.mwz.v1.kafka.KafkaSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    @Autowired
    private KafkaSender kafkaSender;

    @GetMapping("/kafkaTest")
    public void test() {
        kafkaSender.send();
    }

}
