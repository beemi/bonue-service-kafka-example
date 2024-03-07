package com.jaitechltd.bonus.scheduler;

import com.jaitechltd.bonus.repository.BonusRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DatabaseReaderScheduler {

    private final BonusRepository bonusRepository;

    public DatabaseReaderScheduler(BonusRepository bonusRepository) {
        this.bonusRepository = bonusRepository;
    }

    @Scheduled(fixedRate = 5000)
    public void readDatabase() {
        log.info("Reading database ...");
        bonusRepository.findAll().forEach(bonus -> log.info("Bonus: {}", bonus));
    }
}
