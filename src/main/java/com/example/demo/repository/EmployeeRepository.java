package com.example.demo.repository;

import com.example.demo.model.EmployeeEntity;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Long> {
    Optional<EmployeeEntity> findByEmail(String email);
}
