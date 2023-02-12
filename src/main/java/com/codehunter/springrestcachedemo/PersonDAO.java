package com.codehunter.springrestcachedemo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PersonDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private Long id;
    @Setter
    @Getter
    private String name;
    @Setter
    @Getter
    private int age;
}
