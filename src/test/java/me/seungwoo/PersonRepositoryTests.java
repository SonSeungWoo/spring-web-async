package me.seungwoo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Leo.
 * User: ssw
 * Date: 2019-02-12
 * Time: 09:56
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class PersonRepositoryTests {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private PersonRepository personRepository;

    private Person person() {
        return new Person("son", "seungwoo", "ko");
    }

    @Test
    public void findEntityManagerPersonFirstNameTest() {
        Person person = testEntityManager.persist(person());
        Person person1 = testEntityManager.find(Person.class, person.getId());
        assertThat(person.getFirstName()).isEqualTo(person1.getFirstName());
    }

    @Test
    public void 등록테스트() {
        Person person = personRepository.save(person());
        assertThat(person.getId()).isNotNull();
    }

    @Test
    public void 등록조회테스트() {
        Person savePerson = personRepository.save(person());
        Person findPerson = personRepository.findByFirstName(savePerson.getFirstName());
        assertThat(findPerson.getId()).isNotNull();

    }
}
