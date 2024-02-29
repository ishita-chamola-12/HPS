package com.example.hospitalmanagement.entity;

public enum ERole {

//    ROLE_HOSPITAL,
//    ROLE_DOCTOR,
//    ROLE_PATIENT

    // logic-> list of users belonging to different hospital ,
    // and list of admins each from one hospital.
    //->user can only view appointments
    // -> admin can update , delete and create new appointment and view all appointments

    ROLE_USER,
    ROLE_ADMIN
}
