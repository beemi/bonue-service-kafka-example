package com.jaitechltd.bonus.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BonusEvent {
    private String bonusType;
    private String bonusCode;
    private String bonusAmount;
    private String bonusCurrency;
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
