package ma.emsi.ctrl.dao;

import ma.emsi.ctrl.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    public Page<Patient> findByNameContains(String kw, Pageable pageable);

  }