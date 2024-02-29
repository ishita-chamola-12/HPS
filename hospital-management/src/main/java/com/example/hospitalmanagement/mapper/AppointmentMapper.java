package com.example.hospitalmanagement.mapper;

import com.example.hospitalmanagement.dto.AppointmentDto;
import com.example.hospitalmanagement.dto.DoctorDto;
import com.example.hospitalmanagement.dto.PatientDto;
import com.example.hospitalmanagement.entity.Appointment;
import com.example.hospitalmanagement.entity.Doctor;
import com.example.hospitalmanagement.entity.Patient;
import com.example.hospitalmanagement.repository.DoctorRepository;
import com.example.hospitalmanagement.repository.PatientRepository;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@Component
public class AppointmentMapper {

    @Autowired
    private DoctorMapper doctorMapper=new DoctorMapper();

    @Autowired
    private PatientMapper patientMapper=new PatientMapper();

    @Autowired
    private HospitalMapper hospitalMapper=new HospitalMapper();

    public AppointmentDto maptoAppointmentDto(Appointment appointment){


        return new AppointmentDto(
                appointment.getAppointmentId(),
                doctorMapper.maptoDoctorDto(appointment.getDoctor()),
                patientMapper.maptoPatientDto(appointment.getPatient()),
                hospitalMapper.maptoHospitalDto(appointment.getHospital()),
                appointment.getDate(),
                appointment.getTime()
        );
    }

    // method to map list of appointments to list of dtos

    public List<AppointmentDto> maptoAppointmentDtos(List<Appointment>appointments){

        return appointments.stream()
                .map(this::maptoAppointmentDto)
                .collect(Collectors.toList());
        // this collects the list of applications as stream, map them into dto using
        // function then collect them into a list
    }

    public Appointment maptoAppointmentEntity(AppointmentDto appointmentDto){

//        DoctorDto doctorDto=new DoctorDto();
//        PatientDto patientDto=new PatientDto();
        return new Appointment(
                appointmentDto.getAppointmentId(),
                doctorMapper.maptoDoctorEntity(appointmentDto.getDoctor()),
                patientMapper.maptoPatientEntity(appointmentDto.getPatient()),
                hospitalMapper.maptoHospital(appointmentDto.getHospital()),
                appointmentDto.getDate(),
                appointmentDto.getTime()
        );
    }

}
