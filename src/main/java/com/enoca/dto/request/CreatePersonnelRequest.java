package com.enoca.dto.request;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreatePersonnelRequest {

    private String firstName;

    private String lastName;

    private String identityNumber;

    private Long company_id;
}
