package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.Period;

@Data
@Entity
public class Cat {

    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String name;
    private LocalDate dob;
    private String description;
    @Transient
    private int age;

    public int getAge(){
        return Period.between(dob, LocalDate.now()).getYears();
    }
}
