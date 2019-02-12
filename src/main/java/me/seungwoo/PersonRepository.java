package me.seungwoo;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Leo.
 * User: ssw
 * Date: 2019-02-12
 * Time: 09:37
 */
public interface PersonRepository extends CrudRepository<Person, Long> {

    List<Person> findAll();

    Person findByFirstName(String firstName);
}
