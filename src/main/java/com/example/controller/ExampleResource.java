package com.example.controller;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import com.example.model.controller.Dog;
import com.example.model.controller.Person;
import com.example.model.controller.PersonDto;
import com.example.model.repository.controller.DogRepository;
import com.example.model.repository.controller.PersonRepository;

import io.quarkus.hibernate.reactive.panache.Panache;
import io.smallrye.mutiny.Uni;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class ExampleResource {

    @Inject
    private PersonRepository personRepository;

    @Inject
    private DogRepository dogRepository;

    @GET
    @Path("init")
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> init() {
        final Person person = Person.builder().name("person name").birthdate(1).build();
        final Dog dog = Dog.builder().name("dog name").race("race 1").owner(person).build();
        return Panache.withTransaction(() -> personRepository.persist(person).chain(() -> dogRepository.persist(dog)).replaceWith("ok"));
    }

    @GET
    @Path("people")
    public Uni<List<PersonDto>> getListOfPerson() {
        return personRepository.getListOfPersonDtoByID();
    }

}
