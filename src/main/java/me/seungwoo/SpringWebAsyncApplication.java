package me.seungwoo;

import me.seungwoo.domain.Person;
import me.seungwoo.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringWebAsyncApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringWebAsyncApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner (PersonRepository personRepository) {
        return args -> {
            personRepository.save(new Person("son", "seungwoo", "ko"));
            personRepository.findAll().forEach(System.out::println);
        };
    }
}

