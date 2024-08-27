package com.example.flyway.liquibaseEntities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "test_user")
public class TestUser {
    @Column(name = "id", nullable = false)
    @Id
    private Integer id;

    @Column(name = "name", nullable = true, length = Integer.MAX_VALUE)
    private String name;

    @Column(name = "dob")
    private LocalDate dob;

}