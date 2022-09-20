package com.vlad.testtask.repository;

import com.vlad.testtask.model.Laptop;
import org.springframework.data.repository.CrudRepository;

public interface LaptopRepository extends CrudRepository<Laptop, Long> {
}
