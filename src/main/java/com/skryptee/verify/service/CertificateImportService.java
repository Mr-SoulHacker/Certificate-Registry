package com.skryptee.verify.service;

import com.skryptee.verify.dto.CertificateCsvRow;
import com.skryptee.verify.entity.Certificate;
import com.skryptee.verify.repository.CertificateRepository;
import com.skryptee.verify.util.CsvReader;
import com.skryptee.verify.util.QrGenerator;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class CertificateImportService {

    private final CertificateRepository repository;

    private static final DateTimeFormatter DATE_FORMATTER =
            DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public CertificateImportService(CertificateRepository repository) {
        this.repository = repository;
    }

    public int importCertificates(String csvPath) {

        List<CertificateCsvRow> rows = CsvReader.read(csvPath);

        int imported = 0;
        int skipped = 0;

        for (CertificateCsvRow row : rows) {

            if (repository.findByCertificateId(row.getCertificateId()).isPresent()) {

                QrGenerator.generate(row.getCertificateId());

                skipped++;
                continue;
            }

            Certificate certificate = new Certificate();

            certificate.setCertificateId(row.getCertificateId());
            certificate.setStudentName(row.getStudentName());
            certificate.setCollege(row.getCollege());
            certificate.setCourse(row.getCourse());

            certificate.setIssueDate(
                    LocalDate.parse(row.getIssueDate(), DATE_FORMATTER)
            );

            certificate.setStatus(row.getStatus());

            repository.save(certificate);

            QrGenerator.generate(row.getCertificateId());

            imported++;
        }

        System.out.println("--------------------------------");
        System.out.println("Imported : " + imported);
        System.out.println("Skipped  : " + skipped);
        System.out.println("Total CSV: " + rows.size());
        System.out.println("--------------------------------");

        return imported;
    }
}