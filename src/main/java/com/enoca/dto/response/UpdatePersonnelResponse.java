package com.enoca.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class UpdatePersonnelResponse {

    private String firstName;
    private String lastName;
    private Date updatedDate;
    private String identityNumber;
    private String companyName;

}
