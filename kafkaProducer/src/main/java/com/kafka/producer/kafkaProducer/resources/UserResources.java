package com.kafka.producer.kafkaProducer.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
public class UserResources {

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPIC = "Kafka_Producer1";

    @GetMapping("/publish/{message}")
    public String post(@PathVariable("message") final String message){
        kafkaTemplate.send(TOPIC, message);
        return "Published Successfully";
    }

}
