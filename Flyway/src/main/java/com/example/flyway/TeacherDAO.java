package com.example.flyway;


import com.example.flyway.liquibaseEntities.Teacher;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

/**
 * Created by Ayman Alsapagh
 * Date :   8/26/2024
 */
public interface TeacherDAO extends CrudRepository<Teacher, UUID> {}