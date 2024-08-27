package com.example.flyway.liquibaseEntities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "valid_users")
public class ValidUser {
    @Column(name = "id")

    @Id
    private Integer id;

    @Column(name = "name", length = 200)
    private String name;

}