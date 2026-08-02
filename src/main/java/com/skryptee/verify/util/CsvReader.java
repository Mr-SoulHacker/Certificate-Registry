package com.skryptee.verify.util;

import com.opencsv.CSVReader;
import com.skryptee.verify.dto.CertificateCsvRow;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {

    public static List<CertificateCsvRow> read(String path) {

        List<CertificateCsvRow> list = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(path))) {

            // Skip header
            reader.readNext();

            String[] row;

            while ((row = reader.readNext()) != null) {

                CertificateCsvRow dto = new CertificateCsvRow();

                dto.setCertificateId(row[0].trim());
                dto.setStudentName(row[1].trim());
                dto.setCollege(row[2].trim());
                dto.setCourse(row[3].trim());
                dto.setIssueDate(row[4].trim());
                dto.setStatus(row[5].trim());

                list.add(dto);
            }

        } catch (Exception e) {
            throw new RuntimeException("Failed to read CSV file", e);
        }

        return list;
    }
}