package com.example.model.repository.controller;

import javax.enterprise.context.ApplicationScoped;

import com.example.model.controller.Dog;

import io.quarkus.hibernate.reactive.panache.PanacheRepository;

@ApplicationScoped
public class DogRepository implements PanacheRepository<Dog> {

}
