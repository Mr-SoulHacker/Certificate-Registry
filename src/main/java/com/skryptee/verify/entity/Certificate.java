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

    private String registerNumber;

    private String college;

    private String course;

    private Integer score;

    private LocalDate issueDate;

    private String status;
}