package com.enoca.dto.response;

import com.enoca.entity.Company;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class CreatePersonnelResponse {

    private String firstName;
    private String lastName;
    private Date creationDate;
    private String identityNumber;
    private String companyName;
}
