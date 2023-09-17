package com.enoca.util.exception;

import com.enoca.util.constant.ErrorMessage;

public class PersonnelNotFoundException extends RuntimeException{
    public PersonnelNotFoundException(Long id) {
        this.id = id;
    }

    private Long id;

    public String getExMessage(){
        return this.id + " " + ErrorMessage.COMPANY_NOT_FOUDN;
    }
}
