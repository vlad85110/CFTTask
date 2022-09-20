package com.vlad.testtask.service;

import com.vlad.testtask.model.PC;
import com.vlad.testtask.model.Product;
import com.vlad.testtask.model.properties.PCFormFactor;
import com.vlad.testtask.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Optional<Product> getById(long id) {
        return repository.findById(id);
    }

    public <T extends Product> T add(T product) {
        return repository.save(product);
    }

    public Optional<Product> edit(Product product) {
        var optProductToUpdate = repository.findById(product.getId());
        if (optProductToUpdate.isPresent()) {
            var productToUpdate = optProductToUpdate.get();
            editProduct(productToUpdate, product);
            return Optional.of(repository.save(productToUpdate));
        } else {
            return Optional.empty();
        }
    }

    public Optional<Product> delete(long id) {
        var product = repository.findById(id);
        repository.deleteById(id);
        return product;
    }

    protected void editProduct(Product productToUpdate, Product product) {
        productToUpdate.setCost(product.getCost());
        productToUpdate.setManufacturer(product.getManufacturer());
        productToUpdate.setSerialNumber(product.getSerialNumber());
    }
}
