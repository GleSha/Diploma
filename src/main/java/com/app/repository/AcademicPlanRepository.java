package com.app.repository;

import com.app.models.AcademicPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface AcademicPlanRepository extends JpaRepository<AcademicPlan, Long> {

    List<AcademicPlan> findByDateEnd(Date dateEnd);

    Optional<AcademicPlan> findById(Long id);
}
