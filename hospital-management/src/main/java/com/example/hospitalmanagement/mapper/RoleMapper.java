package com.example.hospitalmanagement.mapper;

import com.example.hospitalmanagement.dto.RoleDto;
import com.example.hospitalmanagement.entity.Role;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class RoleMapper {

//    public RoleDto maptoRoleDto(Role role){
//
//        return new RoleDto(
//                role.getRole_id(),
//                role.getName()
//        );
//    }

//    public List<RoleDto> maptoRoleDtos(List<Role> roles){
//        return roles.stream()
//                .map(this::maptoRoleDto)
//                .collect(Collectors.toList());
//    }

//    public Role maptoRole(RoleDto roleDto){
//
//        return new Role(
//                roleDto.getRole_id(),
//                roleDto.getAuthority()
//        );
//    }
}
