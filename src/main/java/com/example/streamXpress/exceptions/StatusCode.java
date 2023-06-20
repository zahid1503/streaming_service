package com.example.streamXpress.exceptions;

public enum StatusCode {
    INTERNAL_SERVER_ERROR(500), NOT_FOUND(404), BAD_REQUEST(400), CONFLICT(409),NO_CONTENT(204);

    private Integer code;

    StatusCode(int code) {
        this.code = code;
    }

    public int getCode() {

        return code;
    }
}
