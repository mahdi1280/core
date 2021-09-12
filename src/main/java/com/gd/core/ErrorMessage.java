package com.gd.core;

public class ErrorMessage {

    private final String message;
    private final String code;

    private ErrorMessage(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public static ErrorMessage error(String msg) {
        return new ErrorMessage(msg, "undefined");
    }

    public static ErrorMessage error(String msg, String code) {
        return new ErrorMessage(msg, code);
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }

}
