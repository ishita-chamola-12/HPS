package com.example.hospitalmanagement.service;

import com.example.hospitalmanagement.dto.AppointmentDto;
import com.example.hospitalmanagement.entity.Appointment;
import com.example.hospitalmanagement.entity.Doctor;
import com.example.hospitalmanagement.entity.Patient;
import com.example.hospitalmanagement.mapper.AppointmentMapper;
import com.example.hospitalmanagement.mapper.DoctorMapper;
import com.example.hospitalmanagement.mapper.PatientMapper;
import com.example.hospitalmanagement.repository.AppointmentRepository;
import com.example.hospitalmanagement.repository.DoctorRepository;
import com.example.hospitalmanagement.repository.PatientRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentService {

    // autowire can resolve conficting beans

    @Autowired
    private  AppointmentRepository appointmentRepository;
    @Autowired
    private AppointmentMapper appointmentMapper;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;
//
//    @Autowired
//    private DoctorMapper doctorMapper;
//
//    @Autowired
//    private PatientMapper patientMapper;

    public List <AppointmentDto> getAllAppointments(){
        List<Appointment> appointments= appointmentRepository.findAll();
        return appointmentMapper.maptoAppointmentDtos(appointments);
    }
    public List <AppointmentDto> getAllAppointmentsbyDocId(Long app_id,Long doc_id){
        List <Appointment> appointments=appointmentRepository.findByAppointmentIdAndDoctorId(app_id,doc_id);
        return appointmentMapper.maptoAppointmentDtos(appointments);
    }
    public AppointmentDto getAppointmentbyId(Long app_id){
        Appointment appointment=appointmentRepository.findByAppointmentId(app_id);
        return appointmentMapper.maptoAppointmentDto(appointment);
    }
    public Appointment addAppointment(AppointmentDto appointmentDto){
        Appointment appointment=appointmentMapper.maptoAppointmentEntity(appointmentDto);
        appointmentRepository.save(appointment);
        return appointment;
    }

    public void deleteAppointment(Long appointmentId){
        Appointment appointment=appointmentRepository.findByAppointmentId(appointmentId);
        appointmentRepository.delete(appointment);

    }

    public Appointment updateAppointment(Long appointmentId,AppointmentDto appointmentDto){
        Appointment toBeUpdated=appointmentRepository.findByAppointmentId(appointmentId);
        Appointment updatedAppointment=appointmentMapper.maptoAppointmentEntity(appointmentDto);
        // hospital cant be updated has to remain same
        toBeUpdated.setDoctor(updatedAppointment.getDoctor());
        toBeUpdated.setPatient(updatedAppointment.getPatient());
        toBeUpdated.setDate(updatedAppointment.getDate());
        toBeUpdated.setTime(updatedAppointment.getTime());
        appointmentRepository.save(toBeUpdated);
        return toBeUpdated;
    }

}
