package com.assassin.exception;

/**
 * Created by work on 2017/4/12.
 */
public class AppointException extends RuntimeException {
    public AppointException(String message){
        super(message);
    }

    public AppointException(String message,Throwable cause){
        super(message,cause);
    }
}
