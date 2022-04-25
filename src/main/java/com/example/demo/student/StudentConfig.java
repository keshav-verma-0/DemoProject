package com.example.demo.student;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student ram= new Student(
                    "ram",
                    "ram@gmail.com",
                    LocalDate.of(2000, Month.JANUARY, 5));
            Student shyam= new Student(
                    "shyam",
                    "shyaam@gmail.com",
                    LocalDate.of(2001, Month.FEBRUARY, 6));

            repository.saveAll(List.of(ram,shyam));

        };
    }
}
