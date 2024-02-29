package com.example.hospitalmanagement.controller;

import com.example.hospitalmanagement.dto.*;
import com.example.hospitalmanagement.entity.AppUser;
import com.example.hospitalmanagement.entity.ERole;
import com.example.hospitalmanagement.entity.Role;
import com.example.hospitalmanagement.jwt.JwtUtils;
import com.example.hospitalmanagement.repository.RoleRepository;
import com.example.hospitalmanagement.repository.UserRepository;
import com.example.hospitalmanagement.request.LoginRequest;
import com.example.hospitalmanagement.request.SignupRequest;
import com.example.hospitalmanagement.response.MessageResponse;
import com.example.hospitalmanagement.response.UserInfoResponse;
import com.example.hospitalmanagement.service.AppointmentService;
import com.example.hospitalmanagement.service.AuthenticationService;
import com.example.hospitalmanagement.service.HospitalService;
import com.example.hospitalmanagement.service.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequestMapping("/api/authentication")
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")


public class AuthenticationController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    private UserDetailsImpl userDetailsImpl;

    @Autowired
    private AuthenticationService authenticationService;

//    @PostMapping("/register")
//    public ResponseEntity<AppUserDto> registerUser(@RequestBody AppUserDto registerUserDto){
//        authenticationService.registerUser(registerUserDto);
//        return new ResponseEntity<>(registerUserDto,HttpStatus.OK);
//    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser( @RequestBody SignupRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
        }

        // Create new user's account
        AppUser user = new AppUser(signUpRequest.getUsername(),
                encoder.encode(signUpRequest.getPassword()));

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;

                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }

        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }


    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser( @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        System.out.println(authentication.isAuthenticated());

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);

        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
                .body(new UserInfoResponse(userDetails.getId(),
                        userDetails.getUsername(),
                        roles));
    }

//    @PostMapping("/saveHospital")
//    public ResponseEntity<HospitalDto> saveHospital(@RequestBody HospitalDto hospitalDto){
//        String username= SecurityContextHolder.getContext().getAuthentication().getName();
//        authenticationService.saveHospital(username,hospitalDto);
//        return new ResponseEntity<>(hospitalDto,HttpStatus.OK);
//    }
//
//    @PostMapping("/saveDoctor")
//    public ResponseEntity<DoctorDto> saveDoctor(@RequestBody DoctorDto doctorDto){
//        String username=SecurityContextHolder.getContext().getAuthentication().getName();
//        authenticationService.saveDoctor(username,doctorDto);
//        return new ResponseEntity<>(doctorDto,HttpStatus.OK);
//    }
//
//    @PostMapping("/savePatient")
//    public ResponseEntity<PatientDto> savePatient(@RequestBody PatientDto patientDto){
//        String username=SecurityContextHolder.getContext().getAuthentication().getName();
//        authenticationService.savePatient(username,patientDto);
//        return new ResponseEntity<>(patientDto,HttpStatus.OK);
//    }
}
