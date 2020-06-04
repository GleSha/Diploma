package com.app.repository;

import com.app.models.Platoon;
import com.app.models.Student;
import com.app.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findById(Long id);

    Optional<Student> findByPlatoon(Platoon platoon);

    Optional<Student> findByUser(User user);


}
