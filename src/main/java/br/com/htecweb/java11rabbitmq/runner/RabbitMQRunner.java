package br.com.htecweb.java11rabbitmq.runner;

import java.util.concurrent.TimeUnit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.com.htecweb.java11rabbitmq.properties.RabbitMQProperties;
import br.com.htecweb.java11rabbitmq.consumer.RabbitMQConsumer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RabbitMQRunner implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;
    private final RabbitMQConsumer rabbitMQConsumer;

    @Override
    public void run(String... args) throws Exception {
        log.info("Sending message...");
        rabbitTemplate.convertAndSend(RabbitMQProperties.TOPIC_EXCHANGE_NAME,
                "foo.bar.baz", "Hello from RabbitMQ!");
        if (rabbitMQConsumer.getCountDownLatch().await(1000, TimeUnit.MILLISECONDS)) {
            log.info("Pass through await...");
        }
    }
}
