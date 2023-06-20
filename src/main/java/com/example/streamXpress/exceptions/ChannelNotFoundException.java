package com.example.streamXpress.exceptions;

public class ChannelNotFoundException extends  RuntimeException{
    private Integer statusCode;
    private String massage;

    public ChannelNotFoundException(StatusCode statusCode, String massage){
        super(massage);
        this.statusCode = statusCode.getCode();
        this.massage = massage;
    }
}