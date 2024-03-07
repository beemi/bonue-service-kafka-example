package com.jaitechltd.bonus.controller;

import com.jaitechltd.bonus.service.BonusService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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

    @Operation(summary = "Get all bonuses",
            description = "Get all bonuses", tags = {"bonus"},
            operationId = "getAllBonus", responses = {@ApiResponse(responseCode = "200", description = "Bonuses found")})
    @GetMapping("/getAll")
    public ResponseEntity<Object> getAllBonus() {
        log.info("Call to get all bonuses");
        return ResponseEntity.ok().body(bonusService.getAllBonus());
    }

}
