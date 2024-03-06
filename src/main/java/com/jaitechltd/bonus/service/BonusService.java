package com.jaitechltd.bonus.service;

import com.jaitechltd.bonus.model.BonusEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class BonusService {
    public void processBonusEvent(BonusEvent bonusEvent) {
        log.info("Processing bonus event: {}", bonusEvent);
    }
}
