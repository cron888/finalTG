package org.example.repository;

import org.example.entity.RuleExecutionStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Optional;

public interface RuleExecutionStatsRepository extends JpaRepository<RuleExecutionStats, Long> {
    Optional<RuleExecutionStats> findByRule_Id(Long ruleId);
    List<RuleExecutionStats> findAllByOrderByRule_IdAsc();

    @Query("SELECT s FROM RuleExecutionStats s LEFT JOIN FETCH s.rule")
    List<RuleExecutionStats> findAllWithRule();
}
