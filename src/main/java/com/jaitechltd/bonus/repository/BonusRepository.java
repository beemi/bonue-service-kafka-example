package com.jaitechltd.bonus.repository;

import com.jaitechltd.bonus.domain.BonusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BonusRepository extends JpaRepository<BonusEntity, Long> {

    Optional<BonusEntity> findById(Long bonusId);

    @Query("SELECT b FROM BonusEntity b WHERE b.bonusCode = ?1")
    Optional<BonusEntity> getBonusByBonusCode(final String bonusCode);

    Optional<BonusEntity> getBonusByBonusType(final String bonusType);
}
