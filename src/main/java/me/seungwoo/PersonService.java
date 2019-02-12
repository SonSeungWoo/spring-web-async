package me.seungwoo;

import lombok.RequiredArgsConstructor;
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

    public List<Person> getPersonList() {
        return personRepository.findAll();
    }
}
