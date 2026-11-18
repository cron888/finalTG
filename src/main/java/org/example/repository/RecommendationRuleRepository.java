package org.example.repository;

import org.example.entity.RecommendationRule;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RecommendationRuleRepository extends JpaRepository<RecommendationRule, Long> {
    List<RecommendationRule> findByActiveTrue();
}
