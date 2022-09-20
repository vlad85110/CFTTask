package com.vlad.testtask.controller;

import com.vlad.testtask.model.HardDrive;
import com.vlad.testtask.model.Laptop;
import com.vlad.testtask.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("laptop")
public class LaptopController {
    private final LaptopService laptopService;

    @Autowired
    public LaptopController(LaptopService laptopService) {
        this.laptopService = laptopService;
    }

    @PostMapping
    public Laptop addLaptop(@RequestBody Laptop laptop) {
        return laptopService.add(laptop);
    }

    @PutMapping
    public Optional<Laptop> edit(@RequestBody Laptop laptop) {
        return laptopService.editLaptop(laptop);
    }

    @GetMapping
    public Iterable<Laptop> findAll() {
        return laptopService.findAllLaptops();
    }
}
