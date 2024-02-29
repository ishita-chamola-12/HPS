package com.example.hospitalmanagement.service;

import com.example.hospitalmanagement.repository.HospitalRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor

public class HospitalService {

    @Autowired
    private HospitalRepository hospitalRepository;

//    @Autowired
//    private HospitalMapper hospitalMapper;

//    @Autowired
//    private SecurityConfiguration securityConfiguration;

//     get hospital details by their username
//    public Hospital getHospitalByName(String name){
//        return hospitalRepository.findByh_name(name);
//
//    }

//    public HospitalDto login(HospitalCredentialsDto hospitalCredentialsDto){
//        Hospital hospital=hospitalRepository.findByh_name(hospitalCredentialsDto.name());
//
//        if(securityConfiguration.passwordEncoder().matches(hospitalCredentialsDto.password(),
//
//                ))
//
//    }


}
