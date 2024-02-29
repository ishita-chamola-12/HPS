package com.example.hospitalmanagement.entity;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="hospital_details")


public class Hospital {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="hospital_id")
    private Long h_id;

    @Column(name="hospital_name")
    private String h_name;

    @Column(name="location")
    private String  location;

    @Column(name="contact")
    private Long contact_no;

    @Column(name="email")
    private String email;

}
