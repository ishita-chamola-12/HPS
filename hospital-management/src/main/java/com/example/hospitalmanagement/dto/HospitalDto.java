package com.example.hospitalmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class HospitalDto {

    private Long h_id;
    private String h_name;
    private String location;
    private Long contact_no;
    private String email;
}
