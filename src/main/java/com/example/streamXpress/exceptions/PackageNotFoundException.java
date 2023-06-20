package com.example.streamXpress.exceptions;

public class PackageNotFoundException  extends  RuntimeException{
    private Integer statusCode;
    private String massage;

    public PackageNotFoundException(StatusCode statusCode, String massage){
        super(massage);
        this.statusCode = statusCode.getCode();
        this.massage = massage;
    }
}
