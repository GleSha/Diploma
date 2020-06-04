package com.app.repository;

import com.app.models.SemesterPlan;
import com.app.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

    Optional<Subject> findById(Long id);

    List<Subject> findByNameAndSemesterPlan(String name, SemesterPlan semesterPlan);

    List<Subject> findByShortNameAndSemesterPlan(String shortName, SemesterPlan semesterPlan);

    List<Subject> findBySemesterPlan(SemesterPlan semesterPlan);

}
