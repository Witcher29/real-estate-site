package com.web_site.real_estate.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "property")
public class Property {
    //В базе данных все id должны идти последовательно друг за другом и начинаться с 1
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate delivery_date;
    private String developer;
    @Column(name = "s_total", columnDefinition = "DECIMAL(5,2)")
    private Double s_total;
    private Integer bedrooms;
    private Integer baths;
    @Column(name = "ceiling_height", columnDefinition = "DECIMAL(5,2)")
    private Double ceiling_height;
    private String facade;
    private String wall_material;
    private String parking;
    private String elevator;
    private String complex_name;
    private String location;
    private String bus_station;
    private String walk;
    private String type;
    private String status;
    private Long price;
    @ElementCollection
    private List<String> images;
    private String metro;
}
