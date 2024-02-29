package com.example.hospitalmanagement.service;


import com.example.hospitalmanagement.dto.*;
import com.example.hospitalmanagement.entity.*;
import com.example.hospitalmanagement.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Set;

@Service
@Transactional
public class AuthenticationService {

    @Autowired
    private AuthenticationManager authenticationManager;

//    @Autowired
//    private TokenService tokenService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private HospitalRepository hospitalRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    public AppUser registerUser(AppUserDto registerUserDto){
        AppUser newUser=new AppUser();
        newUser.setUsername(registerUserDto.getUsername());
        newUser.setPassword(passwordEncoder.encode(registerUserDto.getPassword()));
        Set<Role> newUserRole=registerUserDto.getRoles();
//        Role newUserRole=roleRepository.findByAuthority(String.valueOf(registerUserDto.getAuthority()));
        newUser.setRoles(newUserRole);
        return userRepository.save(newUser);
    }
    public void saveHospital(String username, HospitalDto hospitalDto){
        Hospital hospital=new Hospital();
        hospital.setH_name(username);
        hospital.setLocation(hospitalDto.getLocation());
        hospital.setContact_no(hospitalDto.getContact_no());
        hospital.setEmail(hospitalDto.getEmail());

        hospitalRepository.save(hospital);
    }
    public void saveDoctor(String username, DoctorDto doctorDto){
        Doctor doctor=new Doctor();
        doctor.setDoctor_name(username);
        doctor.setEmail(doctorDto.getEmail());
        doctor.setDoctor_speciality(doctorDto.getDoctor_speciality());
        doctor.setContact_no(doctorDto.getContact_no());
        doctor.setConsultation_fees(doctorDto.getConsultation_fees());

        doctorRepository.save(doctor);
    }

    // function to get age from dob of patient
    private int calculateAge(LocalDate dob){
        LocalDate currentDate=LocalDate.now();
//        System.out.println(Period.between(dob,currentDate).getYears());
        return Period.between(dob,currentDate).getYears();
    }

    public void savePatient(String username, PatientDto patientDto){
        Patient patient=new Patient();
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd-MM-yyyy");
        patient.setPatient_name(username);
        patient.setPatient_dob(patientDto.getPatient_dob());
        int age=calculateAge(LocalDate.parse(patientDto.getPatient_dob(),formatter ));
//        System.out.println(age);
        patient.setPatient_age(age);
        patient.setEmail(patientDto.getEmail());
        patient.setContact_no(patientDto.getContact_no());
//        System.out.println(LocalDate.now());
//        System.out.println(LocalDate.parse(patientDto.getPatient_dob(),formatter ));

        patientRepository.save(patient);

    }

//    public LoginResponseDto loginUser(AppUserDto user){
//
//        try{
//            Authentication auth = authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
//            );
//
//            String token = tokenService.generateJwt(auth);
//            AppUser appUser=userRepository.findByUsername(user.getUsername()).get();
//            AppUserDto userLogin=new AppUserDto();
//
//            userLogin.setUsername(appUser.getUsername());
//            userLogin.setPassword(passwordEncoder.encode(appUser.getPassword()));
//            userLogin.setUser_role(appUser.getUserRole());
//
//
//
//            return new LoginResponseDto(userLogin, token);
//
//        } catch(AuthenticationException e){
//            return new LoginResponseDto(null, "");
//        }
//    }




}
