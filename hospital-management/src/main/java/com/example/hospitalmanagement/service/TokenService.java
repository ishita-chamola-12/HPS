//package com.example.hospitalmanagement.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.oauth2.jwt.JwtClaimsSet;
//import org.springframework.security.oauth2.jwt.JwtDecoder;
//import org.springframework.security.oauth2.jwt.JwtEncoder;
//import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.CrossOrigin;
//
//import java.time.Instant;
//import java.util.stream.Collectors;
//
//@Service
//@CrossOrigin
//
//public class TokenService {
//
//    @Autowired
//    private JwtDecoder jwtDecoder;
//
//    @Autowired
//    private JwtEncoder jwtEncoder;
//
//    public String generateJwt(Authentication auth){
//
//        Instant now=Instant.now();
//        String scope=auth.getAuthorities().stream()
//                .map(GrantedAuthority::getAuthority)
//                .collect(Collectors.joining(" "));
//
//        JwtClaimsSet claims= JwtClaimsSet.builder()
//                .issuer("self")
//                .issuedAt(now)
//                .subject(auth.getName())
//                .claim("roles",scope)
//                .build();
//
//        return jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
//    }
//}
