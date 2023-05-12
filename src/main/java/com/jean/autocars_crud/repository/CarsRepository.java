package com.jean.autocars_crud.repository;

import com.jean.autocars_crud.model.Cars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarsRepository extends JpaRepository<Cars, Long> {
    List<Cars> findAllByPrecoLessThan(double v);
}
