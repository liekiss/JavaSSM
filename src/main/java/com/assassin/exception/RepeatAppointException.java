package com.assassin.exception;

/**
 * Created by work on 2017/4/12.
 */
public class RepeatAppointException extends RuntimeException {
    public RepeatAppointException(String message){
        super(message);
    }

    public RepeatAppointException(String message ,Throwable cause){
        super(message,cause);
    }
}
