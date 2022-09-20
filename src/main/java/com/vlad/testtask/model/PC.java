package com.vlad.testtask.model;

import com.vlad.testtask.model.properties.PCFormFactor;

import javax.persistence.Entity;

@Entity
public class PC extends Product {
    private PCFormFactor formFactor;

    public PCFormFactor getFormFactor() {
        return formFactor;
    }

    public void setFormFactor(PCFormFactor formFactor) {
        this.formFactor = formFactor;
    }
}
