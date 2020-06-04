package com.app.repository;

import com.app.models.ArrivalDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ArrivalDayRepository extends JpaRepository<ArrivalDay, Long> {

    Optional<ArrivalDay> findById(Long id);

    Optional<ArrivalDay> findByDay(Integer day);
}
