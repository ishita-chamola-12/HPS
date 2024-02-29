package com.example.hospitalmanagement.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoResponse {

    // if needed recieve jwt token as well
    private Long user_id;
    private String username;
    private List<String> roles;

}
