package br.com.htecweb.java11rabbitmq.consumer;

import java.util.concurrent.CountDownLatch;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class RabbitMQConsumer {

    private final CountDownLatch countDownLatch = new CountDownLatch(1);

    public void receiveMessage(String message) {
      log.info("Received message: <{}>", message);
      countDownLatch.countDown();
    }

    public CountDownLatch getCountDownLatch() {
        return countDownLatch;
    }
}
