package com.app.repository;

import com.app.models.Lesson;
import com.app.models.Mark;
import com.app.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MarkRepository extends JpaRepository<Mark, Long> {

    Optional<Mark> findById(Long id);

    List<Mark> findByStudentAndLesson(Student student, Lesson lesson);
}
