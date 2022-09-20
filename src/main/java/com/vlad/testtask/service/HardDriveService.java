package com.vlad.testtask.service;

import com.vlad.testtask.model.HardDrive;
import com.vlad.testtask.model.Monitor;
import com.vlad.testtask.model.Product;
import com.vlad.testtask.repository.HardDriveRepository;
import com.vlad.testtask.repository.MonitorRepository;
import com.vlad.testtask.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HardDriveService extends ProductService {
    private final HardDriveRepository hardDriveRepository;

    @Autowired
    public HardDriveService (ProductRepository productRepository, HardDriveRepository hardDriveRepository) {
        super(productRepository);
        this.hardDriveRepository = hardDriveRepository;
    }

    public Optional<HardDrive> editHardDrive(HardDrive product) {
        var optProductToUpdate = hardDriveRepository.findById(product.getId());
        if (optProductToUpdate.isPresent()) {
            var productToUpdate = optProductToUpdate.get();
            editProduct(productToUpdate, product);
            productToUpdate.setSize(product.getSize());
            return Optional.of(hardDriveRepository.save(productToUpdate));
        } else {
            return Optional.empty();
        }
    }

    public Iterable<HardDrive> findAllHardDrives() {
        return hardDriveRepository.findAll();
    }
}
