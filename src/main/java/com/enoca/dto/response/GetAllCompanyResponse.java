package com.enoca.dto.response;

import com.enoca.entity.enums.EType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class GetAllCompanyResponse {
    private Date creationDate;
    private Date updateDate;
    private String companyName;
    private String taxId;
    private String webSite;
    private EType type;
}
