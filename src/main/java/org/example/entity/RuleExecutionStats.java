package org.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "rule_execution_stats")
public class RuleExecutionStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rule_id", nullable = false, unique = true)
    private RecommendationRule rule;

    @Column(name = "rule_name")
    private String ruleName;

    @Column(name = "execution_count", nullable = false)
    private Long executionCount = 0L;

    public RuleExecutionStats() {}

    public RuleExecutionStats(RecommendationRule rule, String ruleName) {
        this.rule = rule;
        this.ruleName = ruleName;
        this.executionCount = 0L;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RecommendationRule getRule() {
        return rule;
    }

    public void setRule(RecommendationRule rule) {
        this.rule = rule;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public Long getExecutionCount() {
        return executionCount;
    }

    public void setExecutionCount(Long executionCount) {
        this.executionCount = executionCount;
    }

    public void increment() {
        this.executionCount++;
    }
}
