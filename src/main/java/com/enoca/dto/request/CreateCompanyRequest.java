package com.enoca.dto.request;

import com.enoca.entity.enums.EType;
import jakarta.persistence.*;
import lombok.Data;

@Data
public class CreateCompanyRequest {

    private String companyName;
    private String taxId;
    private String webSite;
    private EType type;
}
