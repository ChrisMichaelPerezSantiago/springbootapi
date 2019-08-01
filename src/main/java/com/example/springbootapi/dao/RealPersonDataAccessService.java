package com.example.springbootapi.dao;

import com.example.springbootapi.model.Person;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository("postgres")
public class RealPersonDataAccessService implements PersonDao {
    @Override
    public int insertPerson(UUID id, Person person) {
        return 0;
    }

    @Override
    public int deletePersonById(UUID id) {
        return 0;
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        return 0;
    }

    @Override
    public List<Person> selectAllPerson() {
        return Arrays.asList(
                new Person(UUID.randomUUID() , "FROM POSTGRES DB")
        );
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return null;
    }
}
