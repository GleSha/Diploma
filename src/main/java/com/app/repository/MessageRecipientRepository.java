package com.app.repository;

import com.app.models.MessageRecipient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MessageRecipientRepository extends JpaRepository<MessageRecipient, Long> {

    Optional<MessageRecipient> findById(Long id);

    
}
