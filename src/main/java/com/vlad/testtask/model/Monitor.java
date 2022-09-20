package com.vlad.testtask.model;

import javax.persistence.Entity;

@Entity
public class Monitor extends Product {
    private int diagonal;

    public int getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(int diagonal) {
        this.diagonal = diagonal;
    }
}
