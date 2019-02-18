package me.seungwoo.controller;

import lombok.RequiredArgsConstructor;
import me.seungwoo.domain.Person;
import me.seungwoo.service.PersonService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * Created by Leo.
 * User: ssw
 * Date: 2019-02-1
 * Time: 16:16
 */
@RestController
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping("/person/{firstName}")
    public Person getPersonFirstName(@PathVariable String firstName) {
        Person person = personService.findByFirstName(firstName);
        return person;
    }

    @GetMapping("/persons")
    public List<Person> getPersonList() {
        List<Person> personList = personService.findAll();
        return personList;
    }

    //@Async("threadPoolTaskExecutor")
    @GetMapping("/async")
    public Future<String> asyncMethodWithReturnType() {
        try {
            Thread.sleep(5000);
            return new AsyncResult<>("hello world !!!!");
        } catch (final InterruptedException e) {

        }
        return null;
    }

    @GetMapping("/future")
    public CompletableFuture<List<Person>> future() {
        return CompletableFuture.supplyAsync(() -> personService.findAll());
    }
}
