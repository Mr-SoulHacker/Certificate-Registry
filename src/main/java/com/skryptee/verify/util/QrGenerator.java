package com.skryptee.verify.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class QrGenerator {

    private static final String BASE_URL = "http://localhost:8080/v/";

    public static void generate(String certificateId) {

        try {

            String qrContent = BASE_URL + certificateId;

            BitMatrix bitMatrix = new MultiFormatWriter().encode(
                    qrContent,
                    BarcodeFormat.QR_CODE,
                    350,
                    350
            );

            Path outputFolder = Paths.get("qrcodes");

            if (!Files.exists(outputFolder)) {
                Files.createDirectories(outputFolder);
            }

            Path outputFile = outputFolder.resolve(certificateId + ".png");

            MatrixToImageWriter.writeToPath(
                    bitMatrix,
                    "PNG",
                    outputFile
            );

            System.out.println("QR Generated : " + outputFile.toAbsolutePath());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}