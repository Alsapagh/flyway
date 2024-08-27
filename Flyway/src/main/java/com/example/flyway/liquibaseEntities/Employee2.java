package com.example.flyway.liquibaseEntities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "employee_2")
public class Employee2 {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "salary")
    private Long salary;

    @Column(name = "address", length = Integer.MAX_VALUE)
    private String address;

    @Column(name = "hiredate")
    private LocalDate hiredate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_id")
    private Department dept;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "emp_1", nullable = false)
    private Employee1 emp1;

    @Column(name = "yr_exp")
    private Integer yrExp;

}