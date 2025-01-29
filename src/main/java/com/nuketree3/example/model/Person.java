package com.nuketree3.example.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Table(name = "person")
@Entity
@Data
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {

    }
}
