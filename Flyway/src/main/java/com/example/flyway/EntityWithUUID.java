package com.example.flyway;



import jakarta.persistence.Id;

import java.util.UUID;

/**
 * Created by Ayman Alsapagh
 * Date :   8/26/2024
 */

public class EntityWithUUID {
    @Id
    private UUID id;

    public EntityWithUUID() {
        this.id = UUID.randomUUID();
    }
}
