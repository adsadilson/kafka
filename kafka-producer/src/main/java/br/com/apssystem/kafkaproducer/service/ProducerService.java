package br.com.apssystem.kafkaproducer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Log4j2
@RequiredArgsConstructor
@Service
public class ProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        var send = kafkaTemplate.send("topic-2", message);

        try {
            log.info("Partition: {}, Topic: {}, offset: {}", send.get().getRecordMetadata().partition(),
                    send.get().getRecordMetadata().topic(), send.get().getRecordMetadata().offset());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
