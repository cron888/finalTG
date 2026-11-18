package org.example.entity;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "recommendation_rule")
public class RecommendationRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(name = "rule_type", nullable = false)
    private String ruleType;

    @Column(name = "condition", columnDefinition = "TEXT")
    private String condition;

    @Column(name = "is_active")
    private Boolean active = true;

    @Column
    private Integer priority = 0;

    public RecommendationRule() {}

    public RecommendationRule(Long id, String name, String description, String ruleType, String condition, Boolean active, Integer priority) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.ruleType = ruleType;
        this.condition = condition;
        this.active = active;
        this.priority = priority;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRuleType() {
        return ruleType;
    }

    public void setRuleType(String ruleType) {
        this.ruleType = ruleType;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecommendationRule that = (RecommendationRule) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
