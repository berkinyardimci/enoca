package com.enoca.entity;

import com.enoca.entity.enums.EType;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Company extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "company_name",nullable = false, unique = true)
    private String companyName;

    @Column(name = "tax_id", length = 5, unique = true, nullable = false)
    private String taxId;

    @Column(name = "web_site")
    private String webSite;

    @Enumerated(EnumType.STRING)
    private EType type;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Personnel> personnelList = new ArrayList<>();

}
