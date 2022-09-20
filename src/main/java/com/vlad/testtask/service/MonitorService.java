package com.vlad.testtask.service;

import com.vlad.testtask.model.HardDrive;
import com.vlad.testtask.model.Monitor;
import com.vlad.testtask.repository.MonitorRepository;
import com.vlad.testtask.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MonitorService extends ProductService {
    private final MonitorRepository monitorRepository;

    @Autowired
    public MonitorService(ProductRepository productRepository, MonitorRepository monitorRepository) {
        super(productRepository);
        this.monitorRepository = monitorRepository;
    }

    public Optional<Monitor> editMonitor(Monitor product) {
        var optProductToUpdate = monitorRepository.findById(product.getId());
        if (optProductToUpdate.isPresent()) {
            var productToUpdate = optProductToUpdate.get();
            editProduct(productToUpdate, product);
            productToUpdate.setDiagonal(product.getDiagonal());
            return Optional.of(monitorRepository.save(productToUpdate));
        } else {
            return Optional.empty();
        }
    }

    public Iterable<Monitor> findAllMonitors() {
        return monitorRepository.findAll();
    }
}
