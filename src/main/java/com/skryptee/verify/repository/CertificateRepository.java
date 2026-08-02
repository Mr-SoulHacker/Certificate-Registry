package com.skryptee.verify.repository;

import com.skryptee.verify.entity.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CertificateRepository extends JpaRepository<Certificate, String> {

    Optional<Certificate> findByCertificateId(String certificateId);

}
