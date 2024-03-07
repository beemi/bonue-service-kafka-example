package com.jaitechltd.bonus.service;

import com.jaitechltd.bonus.domain.BonusEntity;
import com.jaitechltd.bonus.model.BonusEvent;
import com.jaitechltd.bonus.repository.BonusRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class BonusService {

    private final BonusRepository bonusRepository;

    public BonusService(BonusRepository bonusRepository) {
        this.bonusRepository = bonusRepository;
    }

    /**
     * Process bonus event message and save to database
     *
     * @param bonusEvent Bonus event message from Kafka see {@link BonusEvent}
     */
    public void processBonusEvent(BonusEvent bonusEvent) {
        log.info("Processing bonus event: {}", bonusEvent);
        ModelMapper modelMapper = new ModelMapper();
        BonusEntity bonusEntity = modelMapper.map(bonusEvent, BonusEntity.class);
        bonusRepository.save(bonusEntity);
    }

    public List<BonusEntity> getAllBonus() {
        return bonusRepository.findAll();
    }

    public Object getBonusById(Long id) {
        return bonusRepository.findById(id);
    }
}
