package org.example.service;

import org.example.entity.RecommendationRule;
import org.example.entity.RuleExecutionStats;
import org.example.repository.RecommendationRuleRepository;
import org.example.repository.RuleExecutionStatsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class RuleStatsService {

    private final RuleExecutionStatsRepository statsRepository;
    private final RecommendationRuleRepository ruleRepository;

    public RuleStatsService(RuleExecutionStatsRepository statsRepository,
                            RecommendationRuleRepository ruleRepository) {
        this.statsRepository = statsRepository;
        this.ruleRepository = ruleRepository;
    }

    @Transactional
    public void incrementCount(Long ruleId) {
        Optional<RuleExecutionStats> existing = statsRepository.findByRule_Id(ruleId);
        if (existing.isPresent()) {
            RuleExecutionStats stats = existing.get();
            stats.increment();
            statsRepository.save(stats);
        } else {
            Optional<RecommendationRule> rule = ruleRepository.findById(ruleId);
            if (rule.isPresent()) {
                RuleExecutionStats stats = new RuleExecutionStats(rule.get(), rule.get().getName());
                stats.increment();
                statsRepository.save(stats);
            }
        }
    }

    @Transactional(readOnly = true)
    public List<RuleStatsDTO> getAllStats() {
        List<RecommendationRule> allRules = ruleRepository.findAll();
        List<RuleExecutionStats> statsList = statsRepository.findAllWithRule();

        return allRules.stream().map(rule -> {
            RuleStatsDTO dto = new RuleStatsDTO();
            dto.setRuleId(rule.getId().toString());
            Optional<RuleExecutionStats> statsOpt = statsList.stream()
                    .filter(s -> s.getRule() != null && s.getRule().getId().equals(rule.getId()))
                    .findFirst();
            dto.setCount(statsOpt.map(RuleExecutionStats::getExecutionCount).orElse(0L));
            return dto;
        }).toList();
    }

    @Transactional
    public void deleteStatsForRule(Long ruleId) {
        statsRepository.findByRule_Id(ruleId).ifPresent(statsRepository::delete);
    }

    public static class RuleStatsDTO {
        private String ruleId;
        private Long count;

        public String getRuleId() {
            return ruleId;
        }

        public void setRuleId(String ruleId) {
            this.ruleId = ruleId;
        }

        public Long getCount() {
            return count;
        }

        public void setCount(Long count) {
            this.count = count;
        }
    }
}
