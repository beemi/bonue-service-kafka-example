package com.jaitechltd.bonus.exception;

public class DuplicateBonusException extends RuntimeException{

    public DuplicateBonusException(String message) {
        super(message);
    }
    public DuplicateBonusException(String message, Throwable cause) {
        super(message, cause);
    }
}
