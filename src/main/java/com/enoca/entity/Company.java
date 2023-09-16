package com.enoca.entity;

import com.enoca.entity.enums.EType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Company extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "tax_id", length = 15)
    private String taxId;

    @Column(name = "web_site")
    private String webSite;

    @Enumerated(EnumType.STRING)
    private EType type;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Personnel> personnelList = new ArrayList<>();

}
