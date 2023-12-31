package com.enoca.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class GetAllPersonnelResponse {

    private String firstName;
    private String lastName;
    private String identityNumber;

}
