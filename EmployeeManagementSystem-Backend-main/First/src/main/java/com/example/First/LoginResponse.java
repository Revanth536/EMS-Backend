package com.example.First;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginResponse {

    private Long id;
    private String firstName;
    private String email;
    private String token;
    private String message;

    public LoginResponse(Long id, String firstName, String email, Object o, String loginSuccessful) {
        this.id=id;
        this.firstName=firstName;
        this.email=email;
        this.token=loginSuccessful;
        this.message=loginSuccessful;


    }
}