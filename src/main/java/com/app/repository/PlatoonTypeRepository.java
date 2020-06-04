package com.app.repository;

import com.app.models.PlatoonType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlatoonTypeRepository extends JpaRepository<PlatoonType, Long> {

    Optional<PlatoonType> findById(Long id);

    Optional<PlatoonType> findByName(String name);
}
