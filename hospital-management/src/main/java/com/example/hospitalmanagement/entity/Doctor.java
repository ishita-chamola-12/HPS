package com.example.hospitalmanagement.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="doctor_details")
@Data

public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="doctor_id")
    private Long doctorId;

    // mapping of doctor and hospital
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="hospital_id")
    private Hospital hospital;

    @Column(name="doctor_name")
    private String doctor_name;

    @Column(name="doctor_speciality")
    private String doctor_speciality;

    @Column(name="consultation_fees")
    private String consultation_fees;

    @Column(name="contact_no")
    private Long contact_no;

    @Column(name="email")
    private String email;

}
