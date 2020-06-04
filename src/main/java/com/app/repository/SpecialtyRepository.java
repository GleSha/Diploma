package com.app.repository;

import com.app.models.AcademicPlan;
import com.app.models.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpecialtyRepository extends JpaRepository<Specialty, Long> {

    Optional<Specialty> findById(Long id);

    List<Specialty> findByAcademicPlan(AcademicPlan academicPlan);



}
