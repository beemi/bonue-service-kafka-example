package com.jaitechltd.bonus.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.listener.KafkaListenerErrorHandler;

@Slf4j
@Configuration
public class KafkaTopicConfig {

    public static final String BONUS_TOPIC = "bonus";
    public static final String BONUS_GROUP_ID = "bonus-consumer-group";

    @Bean("customErrorHandler")
    public static KafkaListenerErrorHandler listenerErrorHandler() {
        return (m, e) -> {
            log.error("Bonus listener error: %s%n".formatted(m.toString()), e.fillInStackTrace());
            return m;
        };
    }
}
