package com.example.hospitalmanagement.controller;

import com.example.hospitalmanagement.dto.DoctorDto;
import com.example.hospitalmanagement.dto.PatientDto;
import com.example.hospitalmanagement.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/patients")
@RestController
@RequiredArgsConstructor
@CrossOrigin

public class PatientController {

    private final PatientService patientService;

    @GetMapping("/allPatients")
    public ResponseEntity<List<PatientDto>> getAllPatients(){
        List <PatientDto> patients=patientService.getAllPatients();
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

}
