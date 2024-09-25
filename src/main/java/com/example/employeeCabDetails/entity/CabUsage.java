package com.example.employeeCabDetails.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
public class CabUsage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String employeeName;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate cabDate;
}
