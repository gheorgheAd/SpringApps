package com.example.myfirstone;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyFirstOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyFirstOneApplication.class, args);
    }


    @Bean
    public CommandLineRunner run(EmployeeRepository repository) {
        return (args -> {
            System.out.println(repository.findEmployeeByLastNameContaining(" "));
        });
    }

    private void insertJavaAdvocates(EmployeeRepository repository) {
        repository.save(new Employee("Adina", "Gheorghe"));
        repository.save(new Employee("Maria", "Elena Cosmina"));
        repository.save(new Employee("Ana", "Gheorghe"));
        repository.save(new Employee("Alina", "Gheorghe"));
        repository.save(new Employee("Ioana", "Gheorghe"));
    }
}
