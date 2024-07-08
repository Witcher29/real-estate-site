package com.web_site.real_estate.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String additional_info;
    private String image;
    private String city;

    @OneToMany(mappedBy = "district",fetch = FetchType.LAZY)
    private List<Complex> complexList;
}
