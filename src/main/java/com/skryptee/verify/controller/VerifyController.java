package com.skryptee.verify.controller;

import com.skryptee.verify.entity.Certificate;
import com.skryptee.verify.service.CertificateService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class VerifyController {

    private final CertificateService service;

    public VerifyController(CertificateService service) {
        this.service = service;
    }

    @GetMapping("/v/{id}")
    public String verify(@PathVariable String id, Model model) {

        Certificate certificate = service.getCertificate(id);

        if (certificate == null) {
            return "invalid";
        }

        model.addAttribute("certificate", certificate);

        return "verify";
    }

}