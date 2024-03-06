package com.jaitechltd.bonus.repository;

import com.jaitechltd.bonus.model.BonusEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BonusRepository extends JpaRepository<BonusEvent, Long> {

    Optional<BonusEvent> getBonusByBonusCode(final String bonusCode);

    Optional<BonusEvent> getBonusByBonusType(final String bonusType);
}
