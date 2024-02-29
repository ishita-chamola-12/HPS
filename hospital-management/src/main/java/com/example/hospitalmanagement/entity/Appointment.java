package com.example.hospitalmanagement.entity;

import com.sun.management.HotSpotDiagnosticMXBean;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="appointment_details")
@Data

public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="app_id")
    private Long appointmentId;

    // many to one mapping of many doctors to one appointment detail
    // join column is used to give custom name to foreign key that is generated automaticaly
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="doctor_id")
    private Doctor doctor;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne(cascade=CascadeType.MERGE)
    @JoinColumn(name="hospital_id")
    private Hospital hospital;

    @Column(name="date")
    private String date;

    @Column(name="time")
    private String time;

    // REMOVED LOCATION AND ADDED HOSPITAL AS OBJECT
//    @Column(name="location")
//    private String location;
}
