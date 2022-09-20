package com.vlad.testtask.model;

import com.vlad.testtask.model.properties.LaptopSize;

import javax.persistence.Entity;

@Entity
public class Laptop extends Product {
    private LaptopSize size;

    public LaptopSize getSize() {
        return size;
    }

    public void setSize(LaptopSize size) {
        this.size = size;
    }
}
