package com.app.repository;

import com.app.models.Teacher;
import com.app.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    Optional<Teacher> findById(Long id);

    Collection<Teacher> findByFio(String fio);

    Optional<Teacher> findByUser(User user);

    Optional<Teacher> findByPersonnelNumber(Integer personnelNumber);
}
