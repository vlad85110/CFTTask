package com.vlad.testtask.model;

import javax.persistence.Entity;

@Entity
public class HardDrive extends Product {
    int size;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
