package com.example.hospitalmanagement.repository;

import com.example.hospitalmanagement.entity.Appointment;
import com.example.hospitalmanagement.entity.Doctor;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {



    //extends jpa is done to perform crud operations

    //method to find appointments by doctor id
    // this method is named following Springdatajpa naming convention
    // findBy<AtrributeName>
    // this gets translated into sql query
    // doubt not working without query annotation
    @Modifying
    @Query("SELECT a FROM Appointment a WHERE a.appointmentId=:appointmentId AND a.doctor.doctorId=:doctorId ")
    List <Appointment> findByAppointmentIdAndDoctorId(@Param("appointmentId") Long appointmentId,@Param("doctorId") Long doctorId);

    Appointment findByAppointmentId(Long appointmentId);

//    List<Appointment> findByAppointmentIdAndDoctor(Long appointmentId,Long doctorId);

}
