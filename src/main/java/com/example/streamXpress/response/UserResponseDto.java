package com.example.streamXpress.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserResponseDto {

    private Long id;

    @JsonProperty("user-name")
    private String userName;

    @JsonProperty("email")
    private String email;

    @JsonProperty("password")
    private  String password;
}
