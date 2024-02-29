package com.example.hospitalmanagement.mapper;

import com.example.hospitalmanagement.dto.AppointmentDto;
import com.example.hospitalmanagement.dto.DoctorDto;
import com.example.hospitalmanagement.entity.Appointment;
import com.example.hospitalmanagement.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DoctorMapper {

    @Autowired
    private HospitalMapper hospitalMapper;

    public DoctorDto maptoDoctorDto(Doctor doctor){

        return new DoctorDto(
                doctor.getDoctorId(),
                hospitalMapper.maptoHospitalDto(doctor.getHospital()),
                doctor.getDoctor_name(),
                doctor.getDoctor_speciality(),
                doctor.getConsultation_fees(),
                doctor.getContact_no(),
                doctor.getEmail()
        );
    }

    public List<DoctorDto> maptoDoctorDtos(List<Doctor>doctors){

        return doctors.stream()
                .map(this::maptoDoctorDto)
                .collect(Collectors.toList());
        // this collects the list of applications as stream, map them into dto using
        // function then collect them into a list
    }

    public Doctor maptoDoctorEntity(DoctorDto doctorDto) {

        return new Doctor(
                doctorDto.getDoctorId(),
                hospitalMapper.maptoHospital(doctorDto.getHospital()),
                doctorDto.getDoctor_name(),
                doctorDto.getDoctor_speciality(),
                doctorDto.getConsultation_fees(),
                doctorDto.getContact_no(),
                doctorDto.getEmail()
        );
    }
}
