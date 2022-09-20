package com.vlad.testtask.controller;

import com.vlad.testtask.model.Monitor;
import com.vlad.testtask.service.MonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("monitor")
public class MonitorController {
    private final MonitorService service;

    @Autowired
    public MonitorController(MonitorService service) {
        this.service = service;
    }

    @PostMapping
    public Monitor addLaptop(@RequestBody Monitor monitor) {
        return service.add(monitor);
    }

    @PutMapping
    public Optional<Monitor> edit(@RequestBody Monitor monitor) {
        return service.editMonitor(monitor);
    }

    @GetMapping
    public Iterable<Monitor> findAll() {
        return service.findAllMonitors();
    }
}
