package org.example.controller;

import org.example.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/management")
public class ManagementController {

    private final RecommendationService recommendationService;

    @Autowired(required = false)
    private BuildProperties buildProperties;

    public ManagementController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @PostMapping("/clear-caches")
    public ResponseEntity<String> clearCaches() {
        recommendationService.clearAllRecommendationCache();
        return ResponseEntity.ok("Caches cleared successfully");
    }

    @GetMapping("/info")
    public ResponseEntity<Map<String, String>> info() {
        Map<String, String> info = new LinkedHashMap<>();
        info.put("name", buildProperties != null ? buildProperties.getName() : "recommendation-service");
        info.put("version", buildProperties != null ? buildProperties.getVersion() : "1.0-SNAPSHOT");
        return ResponseEntity.ok(info);
    }
}
