package com.skryptee.verify.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Certificate {

    @Id
    private String certificateId;

    private String studentName;

    private String college;

    private String course;

    private LocalDate issueDate;

    private String status;
}