package com.jean.autocars_crud.controller;

import com.jean.autocars_crud.model.Cars;
import com.jean.autocars_crud.repository.CarsRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cars")
@AllArgsConstructor
public class CarsController {

    private final CarsRepository carsRepository;

    @GetMapping
    public List<Cars> list() {
        Sort sort = Sort.by("marca").ascending();
        return carsRepository.findAll(sort);
    }

    @GetMapping("/{id}")
    public Optional<Cars> getCarById(@PathVariable Long id) {
        return carsRepository.findById(id);
    }
    @GetMapping("/promotion")
    public List<Cars> getCheaperCars() {
        return carsRepository.findAllByPrecoLessThan(50000.0);
    }
    @PostMapping
    public Cars addCar(@RequestBody Cars cars) {
        return carsRepository.save(cars);
    }
    @DeleteMapping("/{id}")
    public void deleteCarById(@PathVariable Long id) {
        carsRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Cars updateCar(@PathVariable Long id, @RequestBody Cars updatedCar) {
        return carsRepository.findById(id)
                .map(car -> {
                    car.setMarca(updatedCar.getMarca());
                    car.setModelo(updatedCar.getModelo());
                    car.setAno(updatedCar.getAno());
                    car.setPreco(updatedCar.getPreco());
                    car.setPortas(updatedCar.getPortas());
                    car.setCor(updatedCar.getCor());
                    car.setImagem(updatedCar.getImagem());
                    return carsRepository.save(car);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Car not found"));
    }
}
