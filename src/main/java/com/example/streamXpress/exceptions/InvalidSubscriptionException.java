package com.example.streamXpress.exceptions;

public class InvalidSubscriptionException extends  RuntimeException{
    private Integer statusCode;
    private String massage;

    public InvalidSubscriptionException(StatusCode statusCode, String massage){
        super(massage);
        this.statusCode = statusCode.getCode();
        this.massage = massage;
    }
}
