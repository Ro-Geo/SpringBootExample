package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;


@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student tim=new Student(
                    "Tim",
                    "tim@gmail.com",
                    LocalDate.of(2000, Month.JANUARY,12),
                    22
            );
            
            Student ron=new Student(
                    "Ron",
                    "ron@gmail.com",
                    LocalDate.of(2002, Month.JANUARY,1),
                    22
            );

            repository.saveAll(
                    Arrays.asList(tim,ron)
            );
        };
    }
}
