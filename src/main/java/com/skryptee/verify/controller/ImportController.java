package com.skryptee.verify.controller;

import com.skryptee.verify.service.CertificateImportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImportController {

    private final CertificateImportService certificateImportService;

    public ImportController(CertificateImportService certificateImportService) {
        this.certificateImportService = certificateImportService;
    }

    @GetMapping("/import")
    public String importCertificates() {

        String csvPath = "uploads/sample_certificates.csv";

        int total = certificateImportService.importCertificates(csvPath);

        return total + " certificates imported successfully.";
    }
}