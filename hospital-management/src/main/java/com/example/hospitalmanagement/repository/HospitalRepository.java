package com.example.hospitalmanagement.repository;

import com.example.hospitalmanagement.entity.Appointment;
import com.example.hospitalmanagement.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface HospitalRepository extends JpaRepository<Hospital,Long> {

//    @Query("SELECT a FROM Hospital a WHERE a.hospital_name=h_name")
//    Hospital findByh_name(String h_name);

}
