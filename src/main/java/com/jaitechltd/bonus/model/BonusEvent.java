package com.jaitechltd.bonus.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BonusEvent {
    private String bonusType;
    private String bonusCode;
    private String bonusStatus;
    private String bonusAmount;
    private String bonusCurrency;
    private LocalDateTime createdAt;
    private LocalDateTime lastModifiedTime;
    private ExtraDetails extraDetails;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ExtraDetails {
        private String extraDetails1;
        private String extraDetails2;
        private String extraDetails3;
    }
}
