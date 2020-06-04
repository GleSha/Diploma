package com.app.repository;

import com.app.models.Message;
import com.app.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    Optional<Message> findById(Long id);

    List<Message> findByUser(User user);
}
