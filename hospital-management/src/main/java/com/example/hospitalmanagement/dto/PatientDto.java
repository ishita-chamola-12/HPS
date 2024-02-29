package com.example.hospitalmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PatientDto {

    private Long patientId;
    private String patient_name;
    private int patient_age;
    private String patient_dob;
    private Long contact_no;
    private String email;
}
