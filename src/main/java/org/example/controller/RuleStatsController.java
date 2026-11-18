package org.example.controller;

import org.example.service.RuleStatsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@RequestMapping("/rule")
public class RuleStatsController {

    private final RuleStatsService ruleStatsService;

    public RuleStatsController(RuleStatsService ruleStatsService) {
        this.ruleStatsService = ruleStatsService;
    }

    @GetMapping("/stats")
    public ResponseEntity<Map<String, Object>> getStats() {
        var stats = ruleStatsService.getAllStats();
        return ResponseEntity.ok(Map.of("stats", stats));
    }
}
