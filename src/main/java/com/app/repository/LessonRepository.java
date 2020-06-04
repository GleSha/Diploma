package com.app.repository;

import com.app.models.Lesson;
import com.app.models.Platoon;
import com.app.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {

    Optional<Lesson> findById(Long id);

    List<Lesson> findByLessonDate(Date lessonDate);

    List<Lesson> findByLessonDateAndPlatoon(Date lessonDate, Platoon platoon);

    List<Lesson> findBySubjectAndPlatoon(Subject subject, Platoon platoon);


}
