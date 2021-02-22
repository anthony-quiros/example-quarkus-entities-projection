package com.example.model.controller;


import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "dog", schema = "example" )
public class Dog {

    @Id
    @GeneratedValue
    public Integer id;

    @Basic
    public String name;

    @Basic
    public String race;

    @ManyToOne
    public Person owner;
}
