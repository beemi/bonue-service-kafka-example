package com.jaitechltd.bonus.controller;

import com.jaitechltd.bonus.service.BonusService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/bonus")
public class BonusController {

    private final BonusService bonusService;

    public BonusController(BonusService bonusService) {
        this.bonusService = bonusService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<Object> getAllBonus() {
        log.info("Call to get all bonuses");
        return ResponseEntity.ok().body(bonusService.getAllBonus());
    }

}
