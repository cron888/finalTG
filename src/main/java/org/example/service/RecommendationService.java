package org.example.service;

import org.example.entity.Product;
import org.example.entity.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RecommendationService {

    private final RuleEngineService ruleEngineService;

    public RecommendationService(RuleEngineService ruleEngineService) {
        this.ruleEngineService = ruleEngineService;
    }

    @Cacheable(value = "recommendations", key = "#user.username")
    public List<Product> getRecommendations(User user) {
        return ruleEngineService.evaluateRulesForUser(user);
    }

    @CacheEvict(value = "recommendations", allEntries = true)
    public void clearAllRecommendationCache() {
        // All entries in "recommendations" cache are evicted
    }
}
