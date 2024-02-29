package com.example.hospitalmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class AppointmentDto {

    private Long appointmentId;
    // in dto the name should be same as what we are calling in frontend->
    // in appointment entity in angular names are = doctor and patient
    private DoctorDto doctor;
    private PatientDto patient;
    private HospitalDto hospital;
    private String date;
    private String time;
//    private String location;

}
