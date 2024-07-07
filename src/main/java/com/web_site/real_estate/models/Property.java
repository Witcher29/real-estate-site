package com.web_site.real_estate.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "property")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate delivery_date;

    @Column(name = "s_total", columnDefinition = "DECIMAL(5,2)")
    private Double s_total;
    private Integer bedrooms;
    private Integer baths;
    @Column(name = "ceiling_height", columnDefinition = "DECIMAL(5,2)")
    private Double ceiling_height;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "complex_id", referencedColumnName = "id", nullable = false)
    private Complex complex;

    private String status;
    private Long price;
    private String image;
}
