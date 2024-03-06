package com.jaitechltd.bonus.service;

import com.jaitechltd.bonus.model.BonusEvent;
import com.jaitechltd.bonus.repository.BonusRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BonusService {

    private final BonusRepository bonusRepository;

    public BonusService(BonusRepository bonusRepository) {
        this.bonusRepository = bonusRepository;
    }

    public void processBonusEvent(BonusEvent bonusEvent) {
        log.info("Processing bonus event: {}", bonusEvent);
        bonusRepository.save(bonusEvent);
    }
}
