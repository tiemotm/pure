package com.example.springreact;

import com.example.springreact.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringReactApplication implements CommandLineRunner {

    final StudentRepository studentRepository;

    public SpringReactApplication(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringReactApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        studentRepository.addStudent(new Student("Tiemo Timtschenko", 1234567, "titim100", "tiemotm"));
    }
}
