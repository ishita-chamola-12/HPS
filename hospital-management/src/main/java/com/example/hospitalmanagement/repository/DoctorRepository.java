package com.example.hospitalmanagement.repository;

import com.example.hospitalmanagement.entity.Appointment;
import com.example.hospitalmanagement.entity.Doctor;
import lombok.Getter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface DoctorRepository extends JpaRepository<Doctor,Long> {

}
