package com.vlad.testtask.repository;

import com.vlad.testtask.model.Monitor;
import org.springframework.data.repository.CrudRepository;

public interface MonitorRepository extends CrudRepository<Monitor, Long> {
}
