package com.example.streamXpress.exceptions;

public class InvalidPlanException extends  RuntimeException{
    private Integer statusCode;
    private String massage;

    public InvalidPlanException(StatusCode statusCode, String massage){
        super(massage);
        this.statusCode = statusCode.getCode();
        this.massage = massage;
    }
}
