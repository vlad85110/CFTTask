package com.vlad.testtask.controller;

import com.vlad.testtask.model.PC;
import com.vlad.testtask.service.PCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("PC")
public class PCController {
    private final PCService service;

    @Autowired
    public PCController(PCService service) {
        this.service = service;
    }

    @PostMapping
    public PC addLaptop(@RequestBody PC pc) {
        return service.add(pc);
    }

    @PutMapping
    public Optional<PC> edit(@RequestBody PC pc) {
        return service.editPC(pc);
    }

    @GetMapping
    public Iterable<PC> findAll() {
        return service.findAllPCs();
    }
}
