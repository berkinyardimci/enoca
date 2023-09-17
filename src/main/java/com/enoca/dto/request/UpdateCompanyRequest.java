package com.enoca.dto.request;

import com.enoca.entity.enums.EType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UpdateCompanyRequest {

    private String companyName;
    private String taxId;
    private String webSite;
    private EType type;
}
