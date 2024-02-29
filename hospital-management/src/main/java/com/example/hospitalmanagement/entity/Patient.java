package com.example.hospitalmanagement.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="patient_details")
@Data

public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="patient_id")
    private Long patientId;

    @Column(name="patient_name")
    private String patient_name;

    @Column(name="patient_age")
    private int patient_age;

    @Column(name="patient_dob")
    private String patient_dob;

    @Column(name="contact_no")
    private Long contact_no;

    @Column(name="email")
    private String email;
}
