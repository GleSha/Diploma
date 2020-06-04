package com.app.repository;

import com.app.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface PlatoonRepository extends JpaRepository<Platoon, Long> {

    Optional<Platoon> findById(Long id);

    List<Platoon> findByName(String name);

    List<Platoon> findByArrivalDay(ArrivalDay arrivalDay);

    List<Platoon> findByCurator(Teacher curator);

    List<Platoon> findByPlatoonType(PlatoonType platoonType);

    List<Platoon> findBySpecialty(Specialty specialty);
}
