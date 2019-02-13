package me.seungwoo;

import me.seungwoo.domain.Person;
import me.seungwoo.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringWebAsyncApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SpringWebAsyncApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringWebAsyncApplication.class);
    }

    @Bean
    CommandLineRunner commandLineRunner (PersonRepository personRepository) {
        return args -> {
            personRepository.save(new Person("son", "seungwoo", "ko"));
            personRepository.findAll().forEach(System.out::println);
        };
    }
}

