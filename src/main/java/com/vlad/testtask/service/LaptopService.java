package com.vlad.testtask.service;

import com.vlad.testtask.model.Laptop;
import com.vlad.testtask.repository.LaptopRepository;
import com.vlad.testtask.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LaptopService extends ProductService {
    private final LaptopRepository laptopRepository;

    @Autowired
    public LaptopService(ProductRepository productRepository, LaptopRepository monitorRepository) {
        super(productRepository);
        this.laptopRepository = monitorRepository;
    }

    public Optional<Laptop> editLaptop(Laptop product) {
        var optProductToUpdate = laptopRepository.findById(product.getId());
        if (optProductToUpdate.isPresent()) {
            var productToUpdate = optProductToUpdate.get();
            editProduct(productToUpdate, product);
            productToUpdate.setSize(product.getSize());
            return Optional.of(laptopRepository.save(productToUpdate));
        } else {
            return Optional.empty();
        }
    }

    public Iterable<Laptop> findAllLaptops() {
        return laptopRepository.findAll();
    }
}
