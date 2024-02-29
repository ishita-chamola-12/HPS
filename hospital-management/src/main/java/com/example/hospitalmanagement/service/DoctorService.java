package com.example.hospitalmanagement.service;

import com.example.hospitalmanagement.dto.DoctorDto;
import com.example.hospitalmanagement.entity.Doctor;
import com.example.hospitalmanagement.mapper.DoctorMapper;
import com.example.hospitalmanagement.repository.DoctorRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor

public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private DoctorMapper doctorMapper;

    public List<DoctorDto> getAllDoctors(){
        List<Doctor> doctors=doctorRepository.findAll();
        return doctorMapper.maptoDoctorDtos(doctors);

    }
}
