package com.example.hospitalmanagement.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user_details",
uniqueConstraints ={
        @UniqueConstraint(columnNames = "username")})
@Data

public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long user_id;

    @Column(name="username", unique = true)
    private String username;

    @Column(name="password")
    private String password;

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="user_role",
    joinColumns = {@JoinColumn(name="user_id")},
    inverseJoinColumns = {@JoinColumn(name="role_id")}
    )
    private Set<Role> roles = new HashSet<>();

    // constructor for only two args
    public AppUser(String username,String password){
        this.username=username;
        this.password=password;
    }

}
