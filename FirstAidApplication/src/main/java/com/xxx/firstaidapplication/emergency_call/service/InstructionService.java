package com.xxx.firstaidapplication.emergency_call.service;

import com.xxx.firstaidapplication.emergency_call.domain.model.Instruction;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class InstructionService {

    public Instruction createInstruction(UUID emergencyCallId, Instruction instruction) {
        instruction.setId(UUID.randomUUID());

        return instruction;

    }

    public List<Instruction> getInstructions(UUID emergencyCallId) {
        return Arrays.asList(
                new Instruction("Instruction"),
                new Instruction("Instruction 1"),
                new Instruction("Instruction 2"));

    }

    public Instruction getInstruction(UUID emergencyCallId, UUID instructionId) {
        return new Instruction("InstructionName " + instructionId);
    }


    public Instruction updateInstruction(UUID instructionId, UUID emergencyCallId, Instruction instruction) {
        return instruction;
    }


    public void deleteInstruction(UUID instructionId, UUID emergencyCallId) {
    }
}
