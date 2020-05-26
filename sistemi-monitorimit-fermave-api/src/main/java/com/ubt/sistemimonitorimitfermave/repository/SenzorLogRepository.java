package com.ubt.sistemimonitorimitfermave.repository;

import com.ubt.sistemimonitorimitfermave.entity.Senzor_Log;
import com.ubt.sistemimonitorimitfermave.entity.Senzori;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SenzorLogRepository extends JpaRepository<Senzor_Log, Long> {
   Senzor_Log findTopBySenzoriOrderByKohaDesc(Senzori senzori);
}
