package com.xxx.firstaidapplication.emergency_call.domain.model;

import com.xxx.firstaidapplication.category.domain.model.Category;
import jakarta.persistence.*;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "emergency_calls")
public class EmergencyCall {

    @Id
    private UUID id;
    private String name;

    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "emergencyCall")
    private Set<Instruction> instructions;

    public EmergencyCall() {
        this.id = UUID.randomUUID();
    }

    public EmergencyCall(String name) {
        this();
        this.name = name;
    }

    public EmergencyCall addInstruction(Instruction instruction){
        if(instructions==null){
            instructions = new LinkedHashSet<>();
            instructions.add(instruction);
        }
        instruction.setEmergencyCall(this);
        instructions.add(instruction);
        return this;
    }

    public Set<Instruction> getInstructions() {
        return Collections.unmodifiableSet(instructions);
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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
        return "EmergencyCall{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
