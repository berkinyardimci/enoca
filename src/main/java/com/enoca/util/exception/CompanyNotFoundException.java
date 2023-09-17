package com.enoca.util.exception;

import com.enoca.util.constant.ErrorMessage;

public class CompanyNotFoundException extends RuntimeException{

    public CompanyNotFoundException( Long id) {
        this.id = id;
    }

    private Long id;

    public String getExMessage(){
        return this.id + " " + ErrorMessage.COMPANY_NOT_FOUDN;
    }



}
