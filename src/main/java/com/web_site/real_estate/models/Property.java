package com.web_site.real_estate.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

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

    @ColumnDefault("false")
    @Column(nullable = false)
    private Boolean isItStudio;

    private Integer baths;
    @Column(name = "ceiling_height", columnDefinition = "DECIMAL(5,2)")
    private Double ceiling_height;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "complex_id", referencedColumnName = "id", nullable = false)
    private Complex complex;

    @JsonProperty("complex_name")
    public String getComplexName() {
        return complex != null ? complex.getComplex_name() : null;
    }

    private String status;
    private Long price;
    private String image;
}
