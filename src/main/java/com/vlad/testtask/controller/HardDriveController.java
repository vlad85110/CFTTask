package com.vlad.testtask.controller;

import com.vlad.testtask.model.HardDrive;
import com.vlad.testtask.service.HardDriveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("HardDrive")
public class HardDriveController {
    private final HardDriveService hardDriveService;

    @Autowired
    public HardDriveController(HardDriveService service) {
        this.hardDriveService = service;
    }

    @PostMapping
    public HardDrive addHardDrive(@RequestBody HardDrive hardDrive) {
        return hardDriveService.add(hardDrive);
    }

    @PutMapping
    public Optional<HardDrive> edit(@RequestBody HardDrive hardDrive) {
        return hardDriveService.editHardDrive(hardDrive);
    }

    @GetMapping
    public Iterable<HardDrive> findAll() {
        return hardDriveService.findAllHardDrives();
    }
}
