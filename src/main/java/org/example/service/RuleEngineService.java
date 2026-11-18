package org.example.service;

import org.example.entity.Product;
import org.example.entity.RecommendationRule;
import org.example.entity.User;
import org.example.repository.RecommendationRuleRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class RuleEngineService {

    private final RecommendationRuleRepository ruleRepository;
    private final ProductService productService;
    private final RuleStatsService ruleStatsService;

    public RuleEngineService(RecommendationRuleRepository ruleRepository,
                             ProductService productService,
                             RuleStatsService ruleStatsService) {
        this.ruleRepository = ruleRepository;
        this.productService = productService;
        this.ruleStatsService = ruleStatsService;
    }

    public List<Product> evaluateRulesForUser(User user) {
        List<RecommendationRule> activeRules = ruleRepository.findByActiveTrue();
        List<Product> matchedProducts = new ArrayList<>();

        for (RecommendationRule rule : activeRules) {
            if (evaluateRule(rule, user)) {
                ruleStatsService.incrementCount(rule.getId());
                List<Product> products = findProductsForRule(rule);
                matchedProducts.addAll(products);
            }
        }
        return matchedProducts.stream()
                .distinct()
                .toList();
    }

    private boolean evaluateRule(RecommendationRule rule, User user) {
        // Placeholder for dynamic rule evaluation logic
        // Currently all active rules match
        return rule.getActive() != null && rule.getActive();
    }

    private List<Product> findProductsForRule(RecommendationRule rule) {
        // Placeholder: return all products for PoC
        // In production, parse rule.condition and filter by category/price/etc.
        return productService.findAll();
    }
}
