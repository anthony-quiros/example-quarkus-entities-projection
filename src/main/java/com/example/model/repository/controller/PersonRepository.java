package com.example.model.repository.controller;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.example.model.controller.Person;
import com.example.model.controller.PersonDto;

import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import io.smallrye.mutiny.Uni;
import lombok.AllArgsConstructor;
import lombok.Data;

@ApplicationScoped
public class PersonRepository implements PanacheRepository<Person> {

    public Uni<List<PersonDto>> getListOfPersonDtoByID() {
        return findAll().project(PersonDto.class).list();
    }

}
