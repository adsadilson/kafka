package br.com.apssystem.kafkaproducer.controller;

import br.com.apssystem.kafkaproducer.service.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequiredArgsConstructor
@RestController
@RequestMapping("/producer")
public class ProducerController {

    private final ProducerService producerService;
    @PostMapping
    public ResponseEntity<?> sendMessage(@RequestBody String message){
        producerService.sendMessage(message);
        return ResponseEntity.status(201).build();
    }
}
