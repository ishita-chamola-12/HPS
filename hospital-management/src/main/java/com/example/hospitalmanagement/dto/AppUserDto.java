package com.example.hospitalmanagement.dto;

import com.example.hospitalmanagement.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppUserDto {

    private Long user_id;
    private String username;
    private String password;
    private Set<Role> roles = new HashSet<>();
}
