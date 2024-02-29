package com.example.hospitalmanagement.controller;

import com.example.hospitalmanagement.dto.RoleDto;
import com.example.hospitalmanagement.entity.Role;
import com.example.hospitalmanagement.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/roles")
@RestController
@RequiredArgsConstructor
@CrossOrigin

public class RoleController {

    @Autowired
    private RoleService roleService;
    @GetMapping("/allRoles")
    public ResponseEntity<List<Role>> getAllRoles(){
        List<Role> roles=roleService.getAllRoles();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }
}
