package com.jaitechltd.bonus.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "bonus")
public class Bonus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @JsonProperty(value = "id")
    private Long id;

    @Column(name = "BONUS_TYPE")
    @JsonProperty(value = "bonusType")
    private String bonusType;

    @Column(name = "BONUS_CODE")
    @JsonProperty(value = "bonusCode")
    private String bonusCode;

    @Column(name = "BONUS_AMOUNT")
    @JsonProperty(value = "bonusAmount")
    private String bonusAmount;

    @Column(name = "BONUS_CURRENCY")
    @JsonProperty(value = "bonusCurrency")
    private String bonusCurrency;

    @Column(name = "CREATED_AT")
    @JsonProperty(value = "createdAt")
    private LocalDateTime createdAt;

    @Column(name = "LAST_MODIFIED_TIME")
    @JsonProperty(value = "lastModifiedTime")
    private LocalDateTime lastModifiedTime;
}
