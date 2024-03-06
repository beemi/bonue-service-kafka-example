package com.jaitechltd.bonus.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.listener.KafkaListenerErrorHandler;

@Slf4j
@Configuration
public class KafkaTopicConfig {

    private static final String TOPIC_NAME = "bonus";

    @Bean
    public String getTopicName() {
        return TOPIC_NAME;
    }

    @Bean("customErrorHandler")
    public static KafkaListenerErrorHandler listenerErrorHandler() {
        return (m, e) -> {
            log.error("Bonus listener error: %s%n".formatted(m.toString()), e.fillInStackTrace());
            return m;
        };
    }
}
