package com.jaitechltd.bonus.messaging;

import com.jaitechltd.bonus.config.KafkaTopicConfig;
import com.jaitechltd.bonus.model.BonusEvent;
import com.jaitechltd.bonus.service.BonusService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class BonusEventProcessor {

    private final BonusService bonusService;

    @KafkaListener(topics = KafkaTopicConfig.BONUS_TOPIC, groupId = KafkaTopicConfig.BONUS_GROUP_ID,
            errorHandler = "customErrorHandler",
            properties = {
                    "spring.json.value.default.type:com.jaitechltd.bonus.model.BonusEvent"
            })
    public void processBonusEvent(BonusEvent bonusEvent) {
        log.info("Received bonus event: {}", bonusEvent);
        bonusService.processBonusEvent(bonusEvent);
    }
}
