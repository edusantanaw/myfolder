package com.myfolder.myfolder.domain.exceptions;

public class DomainValidationException extends  Exception {
    public DomainValidationException(String message){
            super(message);
    }
}
