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
@Table(name = "complex")
public class Complex {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate delivery_date;
    @Column(name = "s_total", columnDefinition = "DECIMAL(5,2)")
    private Double s_total;

    @Column(name = "ceiling_height", columnDefinition = "DECIMAL(5,2)")
    private Double ceiling_height;
    private String facade;
    private String wall_material;
    private String parking;
    private String elevator;
    private String complex_name;
    private Integer number_of_buildings;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "district_id", referencedColumnName = "id")
    private District district;

    @ManyToOne
    @JoinColumn(name = "developer_id", referencedColumnName = "id")
    private Developer developer;


    private String bus_station;
    private String walk;
    private String type;
    private String status;
    private Long price;
    private String image;
    private String metro;
}
