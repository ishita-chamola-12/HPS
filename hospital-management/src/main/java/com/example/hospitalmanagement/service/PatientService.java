package com.example.hospitalmanagement.service;

import com.example.hospitalmanagement.dto.PatientDto;
import com.example.hospitalmanagement.entity.Doctor;
import com.example.hospitalmanagement.entity.Patient;
import com.example.hospitalmanagement.mapper.PatientMapper;
import com.example.hospitalmanagement.repository.PatientRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
@AllArgsConstructor

public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientMapper patientMapper;

    public List<PatientDto> getAllPatients(){
        List<Patient> doctors=patientRepository.findAll();
        return patientMapper.maptoPatientDtos(doctors);

    }

}
