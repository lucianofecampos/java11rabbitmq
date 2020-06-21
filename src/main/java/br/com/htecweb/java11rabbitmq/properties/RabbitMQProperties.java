package br.com.htecweb.java11rabbitmq.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
public class RabbitMQProperties {

    public static String TOPIC_EXCHANGE_NAME;

    public static String QUEUE_NAME;

    @Value("${topic.exchange.name:spring-boot-exchange}")
    public void setTopicExchangeName(String topicExchangeName) {
        TOPIC_EXCHANGE_NAME = topicExchangeName;
    }

    @Value("${rabbit.queue.name:spring-boot}")
    public void setQueueName(String queueName) {
        QUEUE_NAME = queueName;
    }
}
