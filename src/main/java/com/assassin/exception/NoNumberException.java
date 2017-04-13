package com.assassin.exception;

/**
 * Created by work on 2017/4/12.
 */
public class NoNumberException extends RuntimeException {
    public NoNumberException(String message){
        super(message);
    }

    public NoNumberException(String message,Throwable cause){
        super(message,cause);
    }
}
