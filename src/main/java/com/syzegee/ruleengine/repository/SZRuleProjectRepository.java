package com.syzegee.ruleengine.repository;

import com.syzegee.ruleengine.entity.SzRule;
import com.syzegee.ruleengine.entity.SzRuleDetails;
import com.syzegee.ruleengine.entity.SzRuleProject;
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
public interface SZRuleProjectRepository extends JpaRepository<SzRuleProject, Long> {

    @Query(" from SzRuleProject where isActive=true and projectId=:projectId")
    public SzRuleProject getSzRuleProjectById(@Param("projectId") Long projectId);

    @Query(" from SzRuleProject where isActive=true and customerId=:customerId")
    public SzRuleProject getSzRuleProjectByCustomerId(@Param("customerId") String customerId);

    @Query(" from SzRuleProject where projectCode=:projectCode and projectName=:projectName and customerId=:customerId")
    public List<SzRuleProject> getSzRuleProjectByCustIdProjCodeNProjName(@Param("projectCode") String projectCode,
                                                                   @Param("projectName") String projectName,
                                                                   @Param("customerId") String customerId);

    @Query(" from SzRuleProject where isActive=true and projectName=:projectName")
    public SzRuleProject getSzRuleProjectByProjectName(@Param("projectName") String projectName);

    @Query(" from SzRuleProject where isActive=true")
    public List<SzRuleDetails> getAllSzRuleProjects();

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(" update SzRuleProject set isActive =false where projectId=:projectId")
    int deleteSzRuleProjectById(@Param("projectId") Long projectId);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(" update SzRuleProject set isActive =false where customerId=:customerId")
    int deleteSzRuleProjectByCustomerId(@Param("customerId") String customerId);
}
