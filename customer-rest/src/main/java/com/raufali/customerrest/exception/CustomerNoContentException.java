package com.raufali.customerrest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class CustomerNoContentException extends RuntimeException{

    public CustomerNoContentException(String message){
        super(message);
    }
}
