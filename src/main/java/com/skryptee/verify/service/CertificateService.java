package com.skryptee.verify.service;

import com.skryptee.verify.entity.Certificate;
import com.skryptee.verify.repository.CertificateRepository;
import org.springframework.stereotype.Service;

@Service
public class CertificateService {

    private final CertificateRepository repository;

    public CertificateService(CertificateRepository repository) {
        this.repository = repository;
    }

    public Certificate getCertificate(String id) {
        return repository.findByCertificateId(id).orElse(null);
    }
}