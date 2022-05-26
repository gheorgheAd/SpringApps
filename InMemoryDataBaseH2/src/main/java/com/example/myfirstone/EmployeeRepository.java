package com.example.myfirstone;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
   Employee findEmployeeByLastNameContaining(String word);
}
