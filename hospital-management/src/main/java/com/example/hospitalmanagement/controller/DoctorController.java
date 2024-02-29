package com.example.hospitalmanagement.controller;

import com.example.hospitalmanagement.dto.AppointmentDto;
import com.example.hospitalmanagement.dto.DoctorDto;
import com.example.hospitalmanagement.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/doctors")
@RestController
@RequiredArgsConstructor
@CrossOrigin

public class DoctorController {

    private final DoctorService doctorService;

    @GetMapping("/allDoctors")
    public ResponseEntity<List<DoctorDto>> getAllDoctors(){
        List <DoctorDto> doctors=doctorService.getAllDoctors();
        return new ResponseEntity<>(doctors, HttpStatus.OK);}
}
