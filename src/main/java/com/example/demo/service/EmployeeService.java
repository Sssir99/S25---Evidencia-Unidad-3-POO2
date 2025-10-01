package com.example.demo.service;

import com.example.demo.model.EmployeeEntity;
import com.example.demo.repository.EmployeeRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public Iterable<EmployeeEntity> getAll() {
        return repository.findAll();
    }

    public Optional<EmployeeEntity> getById(Long id) {
        return repository.findById(id);
    }

    public EmployeeEntity createOrUpdate(EmployeeEntity incoming) {
        if (incoming.getId() != null && repository.existsById(incoming.getId())) {
            EmployeeEntity current = repository.findById(incoming.getId()).orElseThrow();
            current.setFirstName(incoming.getFirstName());
            current.setLastName(incoming.getLastName());
            current.setEmail(incoming.getEmail());
            return repository.save(current);
        }
        return repository.save(incoming);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
