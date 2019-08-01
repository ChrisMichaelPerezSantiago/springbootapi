package com.example.springbootapi.dao;


import com.example.springbootapi.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class PersonDataAccessService implements PersonDao{
    private static List<Person> personDB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        personDB.add(new Person(id , person.getName()));
        return 1;
    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<Person> person = selectPersonById(id);
        if(!person.isPresent()){
            return 0;
        }else{
            personDB.remove(person.get());
            return 1;
        }
    }

    @Override
    public int updatePersonById(UUID id, Person updatePerson) {
        return selectPersonById(id)
                .map(p ->{
                    int index = personDB.indexOf(p);
                    if(index >= 0){
                        personDB.set(index , new Person(id , updatePerson.getName()));
                        return 1;
                    }
                    return 0;
                }).orElse(0);
    }

    @Override
    public List<Person> selectAllPerson() {
        return personDB;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return personDB.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }
}
