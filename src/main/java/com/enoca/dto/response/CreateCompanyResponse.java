package com.enoca.dto.response;

import com.enoca.entity.enums.EType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCompanyResponse {
    private Long id;
    private String companyName;
    private String taxId;
    private String webSite;
    private EType type;

}
