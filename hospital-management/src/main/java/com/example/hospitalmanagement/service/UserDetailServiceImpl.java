package com.example.hospitalmanagement.service;


// used to match up username and password to authorize

import com.example.hospitalmanagement.entity.AppUser;
import com.example.hospitalmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user= userRepository.findByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException("No user found"));
        return UserDetailsImpl.build(user);
    }
}
