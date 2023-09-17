package com.enoca.dto.response;

import com.enoca.entity.enums.EType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Builder
@Getter
@Setter
public class UpdateCompanyResponse {
    private String companyName;
    private String taxId;
    private String webSite;
    private EType type;
    private Date updatedDate;
}
