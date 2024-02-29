package com.example.hospitalmanagement.dto;

import com.example.hospitalmanagement.entity.Hospital;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class DoctorDto {

    private Long doctorId;
    private HospitalDto hospital;
    private String doctor_name;
    private String doctor_speciality;
    private String consultation_fees;
    private Long contact_no;
    private String email;

}
