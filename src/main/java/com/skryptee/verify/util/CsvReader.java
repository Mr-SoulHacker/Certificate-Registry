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

            reader.readNext();

            String[] row;

            while ((row = reader.readNext()) != null) {

                CertificateCsvRow dto = new CertificateCsvRow();

                dto.setStudentName(row[0]);
                dto.setRegisterNumber(row[1]);
                dto.setCollege(row[2]);
                dto.setCourse(row[3]);
                dto.setScore(Integer.parseInt(row[4]));
                dto.setIssueDate(row[5]);
                dto.setCertificateId(row[6]);
                dto.setStatus(row[7]);

                list.add(dto);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return list;
    }
}