package com.example.streamXpress.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class UserRequestDto {

    private Long id;


    @JsonProperty("user-name")
    private String userName;

    @JsonProperty("email")
    private String email;

    @JsonProperty("password")
    private  String password;
}
