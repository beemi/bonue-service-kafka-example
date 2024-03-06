package com.jaitechltd.bonus.repository;

import com.jaitechltd.bonus.domain.Bonus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BonusRepository extends JpaRepository<Bonus, Long> {

    @Query("SELECT b FROM Bonus b WHERE b.bonusCode = ?1")
    Optional<Bonus> getBonusByBonusCode(final String bonusCode);

    Optional<Bonus> getBonusByBonusType(final String bonusType);
}
