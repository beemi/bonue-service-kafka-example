package com.jaitechltd.bonus.exception;

public class FtpUpdaterException extends RuntimeException {

    public FtpUpdaterException(String message) {
        super(message);
    }

    public FtpUpdaterException(String message, Throwable cause) {
        super(message, cause);
    }
}
