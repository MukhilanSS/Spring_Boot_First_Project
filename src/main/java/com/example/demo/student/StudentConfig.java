package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.cglib.core.Local;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository)
    {
        return args ->{
             Student mukhil=new Student(

                     "Mukhil",
                     "210701169@rajalakshmi.edu.in",
                     LocalDate.of(2004, Month.JUNE,23)
             );
            Student melon=new Student(
                    "Melon",
                    "210701164@rajalakshmi.edu.in",
                    LocalDate.of(2004, Month.FEBRUARY,2)
            );
            repository.saveAll(
                    List.of(mukhil,melon)
            );
        };
    }
}

