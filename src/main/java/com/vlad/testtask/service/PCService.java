package com.vlad.testtask.service;

import com.vlad.testtask.model.HardDrive;
import com.vlad.testtask.model.Monitor;
import com.vlad.testtask.model.PC;
import com.vlad.testtask.repository.MonitorRepository;
import com.vlad.testtask.repository.PCRepository;
import com.vlad.testtask.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PCService extends ProductService {
    private final PCRepository pcRepository;

    @Autowired
    public PCService(ProductRepository productRepository, PCRepository pcRepository) {
        super(productRepository);
        this.pcRepository = pcRepository;
    }

    public Optional<PC> editPC(PC product) {
        var optProductToUpdate = pcRepository.findById(product.getId());
        if (optProductToUpdate.isPresent()) {
            var productToUpdate = optProductToUpdate.get();
            editProduct(productToUpdate, product);
            productToUpdate.setFormFactor(product.getFormFactor());
            return Optional.of(pcRepository.save(productToUpdate));
        } else {
            return Optional.empty();
        }
    }

    public Iterable<PC> findAllPCs() {
        return pcRepository.findAll();
    }
}
