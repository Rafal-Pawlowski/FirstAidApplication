package com.xxx.firstaidapplication.emergency_call.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "instructions")
public class Instruction {

    @Id
    private UUID id;
    private String name;

    @ManyToOne
    private EmergencyCall emergencyCall;

    public Instruction() {
        this.id = UUID.randomUUID();
    }

    public Instruction(String name) {
        this();
        this.name = name;
    }

    public EmergencyCall getEmergencyCall() {
        return emergencyCall;
    }

    public void setEmergencyCall(EmergencyCall emergencyCall) {
        this.emergencyCall = emergencyCall;
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
