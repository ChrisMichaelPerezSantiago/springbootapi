package com.example.springbootapi.service;


import com.example.springbootapi.dao.PersonDao;
import com.example.springbootapi.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {
    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("fakeDao") PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person){
        return personDao.insertPerson(person);
    }

    public List<Person> getAllPersons(){
        return personDao.selectAllPerson();
    }

    public Optional<Person> getPersonById(UUID id){
       return personDao.selectPersonById(id);
    }

    public int deletePerson(UUID id){
        return personDao.deletePersonById(id);
    }

    public int updatePerson(UUID id , Person newPersonToAdd){
        return personDao.updatePersonById(id , newPersonToAdd);
    }
}
