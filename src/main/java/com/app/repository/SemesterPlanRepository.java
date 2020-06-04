package com.app.repository;

import com.app.models.SemesterPlan;
import com.app.models.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SemesterPlanRepository extends JpaRepository<SemesterPlan, Long> {

    Optional<SemesterPlan> findById(Long id);

    List<SemesterPlan> findBySpecialty(Specialty specialty);

    Optional<SemesterPlan> findBySpecialtyAndSemesterNumber(Specialty specialty, Integer semesterNumber);
}
