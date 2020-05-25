package com.ubt.sistemimonitorimitfermave.repository;
import com.ubt.sistemimonitorimitfermave.entity.Senzori;
import org.springframework.data.jpa.repository.JpaRepository;
import sun.management.Sensor;

public interface SenzoriRepository extends JpaRepository<Senzori, Long> {

}
