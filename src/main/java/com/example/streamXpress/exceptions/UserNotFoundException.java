package com.example.streamXpress.exceptions;

public class UserNotFoundException extends  RuntimeException{
    private Integer statusCode;
    private String massage;

    public UserNotFoundException(StatusCode statusCode, String massage){
        super(massage);
        this.statusCode = statusCode.getCode();
        this.massage = massage;
    }
}
