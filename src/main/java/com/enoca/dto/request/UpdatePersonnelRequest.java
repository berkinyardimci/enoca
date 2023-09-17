package com.enoca.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UpdatePersonnelRequest {

    private String firstName;

    private String lastName;

    private Long company_id;

}
