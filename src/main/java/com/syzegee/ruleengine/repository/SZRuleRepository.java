package com.syzegee.ruleengine.repository;

import com.syzegee.ruleengine.entity.SzRule;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Ram Prasad
 */
@Repository
public interface SZRuleRepository extends JpaRepository<SzRule, Long>{
    @Query(" from SzRule where isActive=true and ruleId=:ruleId")
    public SzRule getSzRuleById(@Param("ruleId") Long ruleId);

    @Query(" from SzRule where isActive=true ")
    public List<SzRule> getAllSzRules();

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(" update SzRule set isActive =false where ruleId=:ruleId")
    int deleteSzRuleById(@Param("ruleId") Long ruleId);
}
