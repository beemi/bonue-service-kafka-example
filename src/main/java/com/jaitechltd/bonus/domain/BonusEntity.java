package com.jaitechltd.bonus.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bonus", schema = "dbo")
public class BonusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "BONUS_TYPE")
    private String bonusType;

    @Column(name = "BONUS_STATUS")
    private String bonusStatus;

    @Column(name = "BONUS_CODE")
    private String bonusCode;

    @Column(name = "BONUS_AMOUNT")
    private String bonusAmount;

    @Column(name = "BONUS_CURRENCY")
    private String bonusCurrency;

    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

    @Column(name = "LAST_MODIFIED_TIME")
    private LocalDateTime lastModifiedTime;
}
