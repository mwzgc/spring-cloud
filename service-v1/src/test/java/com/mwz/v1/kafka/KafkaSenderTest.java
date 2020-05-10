package com.mwz.v1.kafka;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class KafkaSenderTest {

    @Autowired
    private KafkaSender kafkaSender;

    @Test
    void send() {
        kafkaSender.send();
    }
}