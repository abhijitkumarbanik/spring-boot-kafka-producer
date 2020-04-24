package com.spring.kafka.producer.controller;

import com.spring.kafka.producer.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class ProducerController {

    Logger logger = LoggerFactory.getLogger(ProducerController.class);
    public static final String TOPIC = "DATA";

    @Autowired
    KafkaTemplate template;

    @PostMapping("/publish")
    public @ResponseBody
    Employee sendMessage(@RequestBody Employee employee)
    {
        logger.info("Producer sent a message "+ employee);
        template.send(TOPIC, employee);
        return employee;
    }

}
