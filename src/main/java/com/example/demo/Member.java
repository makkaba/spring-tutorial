package com.example.demo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Member {

    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
}
