package com.example.hospitalmanagement.controller;
// api are build in this class

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;



import com.example.hospitalmanagement.dto.AppointmentDto;
import com.example.hospitalmanagement.entity.Appointment;
import com.example.hospitalmanagement.service.AppointmentService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/appointments")
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")

public class AppointmentController {

    private final AppointmentService appointmentService;

    @GetMapping("/allAppointments")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<AppointmentDto>> getAllAppointments(){
        List <AppointmentDto> appointments=appointmentService.getAllAppointments();
        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }
    @GetMapping("/appointment/{app_id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<AppointmentDto> getAppointmentById(@PathVariable Long app_id){
        AppointmentDto appointment=appointmentService.getAppointmentbyId(app_id);
        return new ResponseEntity<>(appointment,HttpStatus.OK);
    }
    @GetMapping("/{app_id}/doctors/{doc_id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<AppointmentDto>> getAppointmentByDocId(@PathVariable Long app_id, @PathVariable Long doc_id){
        List<AppointmentDto> appointments=appointmentService.getAllAppointmentsbyDocId(app_id,doc_id);
        return new ResponseEntity<>(appointments,HttpStatus.OK);
    }
    @PostMapping("/newAppointment")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Appointment> addAppointment(@RequestBody AppointmentDto appointmentDto){
        Appointment appointment=appointmentService.addAppointment(appointmentDto);
        return new ResponseEntity<>(appointment,HttpStatus.OK);
    }

    @DeleteMapping("/{app_id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Appointment> deleteAppointment(@PathVariable Long app_id){
        appointmentService.deleteAppointment(app_id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/updateAppointment/{app_id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Appointment> updateAppointment(@PathVariable Long app_id, @RequestBody AppointmentDto appointmentDto){
        // appointment dto is update
        Appointment appointment=appointmentService.updateAppointment(app_id,appointmentDto);
        return new ResponseEntity<>(appointment,HttpStatus.OK);
    }

}
