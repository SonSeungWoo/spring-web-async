package me.seungwoo.service;

import lombok.RequiredArgsConstructor;
import me.seungwoo.domain.Person;
import me.seungwoo.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Leo.
 * User: ssw
 * Date: 2019-02-12
 * Time: 09:41
 */
@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;


    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person findByFirstName(String firstName) {
        return personRepository.findByFirstName(firstName);
    }
}
