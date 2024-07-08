package com.web_site.real_estate.repo;

import com.web_site.real_estate.models.Complex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ComplexRepository extends JpaRepository<Complex, Integer> {
    @Query("SELECT c FROM Complex c WHERE c.complex_name = :complexName")
    List<Complex> findAllByComplexName(@Param("complexName") String complexName);
}
