package com.example.hospitalmanagement.mapper;

import com.example.hospitalmanagement.dto.DoctorDto;
import com.example.hospitalmanagement.dto.PatientDto;
import com.example.hospitalmanagement.entity.Doctor;
import com.example.hospitalmanagement.entity.Patient;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PatientMapper {

    public PatientDto maptoPatientDto(Patient patient){
        return new PatientDto(
                patient.getPatientId(),
                patient.getPatient_name(),
                patient.getPatient_age(),
                patient.getPatient_dob(),
                patient.getContact_no(),
                patient.getEmail()
        );
    }

    public List<PatientDto> maptoPatientDtos(List<Patient>patients){

        return patients.stream()
                .map(this::maptoPatientDto)
                .collect(Collectors.toList());
        // this collects the list of applications as stream, map them into dto using
        // function then collect them into a list
    }

    public Patient maptoPatientEntity(PatientDto patientDto){
        return new Patient(
                patientDto.getPatientId(),
                patientDto.getPatient_name(),
                patientDto.getPatient_age(),
                patientDto.getPatient_dob(),
                patientDto.getContact_no(),
                patientDto.getEmail()
        );
    }
}
