package com.example.hospitalmanagement.service;

import com.example.hospitalmanagement.dto.RoleDto;
import com.example.hospitalmanagement.entity.Role;
import com.example.hospitalmanagement.mapper.RoleMapper;
import com.example.hospitalmanagement.repository.RoleRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RoleMapper roleMapper;

    public List<Role> getAllRoles(){
        List<Role> roles=roleRepository.findAll();
        return roles;
//        return roleMapper.maptoRoleDtos(roles);
    }
}
