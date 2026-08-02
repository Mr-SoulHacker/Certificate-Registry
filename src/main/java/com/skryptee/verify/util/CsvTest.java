package com.skryptee.verify.util;

import com.skryptee.verify.dto.CertificateCsvRow;

public class CsvTest {

    public static void main(String[] args) {

        CsvReader.read("uploads/prathyusha SAP.csv")
                .forEach(System.out::println);

    }

}