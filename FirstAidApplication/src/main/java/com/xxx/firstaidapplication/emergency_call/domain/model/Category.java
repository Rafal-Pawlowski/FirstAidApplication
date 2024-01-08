package com.xxx.firstaidapplication.emergency_call.domain.model;

import java.util.UUID;

public class Category {

    private String name;
    private UUID id;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
        this.id=UUID.randomUUID();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
