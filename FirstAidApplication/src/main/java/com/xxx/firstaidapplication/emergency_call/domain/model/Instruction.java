package com.xxx.firstaidapplication.emergency_call.domain.model;

import java.util.UUID;

public class Instruction {

    private UUID id;
    private String name;

    public Instruction() {
    }

    public Instruction(String name) {
        this.name = name;
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Instruction{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
