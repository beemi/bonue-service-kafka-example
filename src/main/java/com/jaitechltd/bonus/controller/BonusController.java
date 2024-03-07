package com.jaitechltd.bonus.controller;

import com.jaitechltd.bonus.service.BonusService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Bonus API", description = "Retrieve bonus data.")
@Slf4j
@RestController
@RequestMapping("/api/v1/bonus")
public class BonusController {

    private final BonusService bonusService;

    public BonusController(BonusService bonusService) {
        this.bonusService = bonusService;
    }

    @GetMapping("/get/{id}")
    @Operation(summary = "Get a bonus by id",
            description = "Get a bonus by id", tags = {"bonus"},
            operationId = "getBonus", responses = {@ApiResponse(responseCode = "200", description = "Bonus found")})
    public ResponseEntity<Object> getBonusById(final @PathVariable Long id) {
        log.info("Call to get bonus by id - {}", id);
        return ResponseEntity.ok().body(bonusService.getBonusById(id));
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
