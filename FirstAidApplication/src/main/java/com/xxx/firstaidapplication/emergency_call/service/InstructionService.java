package com.xxx.firstaidapplication.emergency_call.service;

import com.xxx.firstaidapplication.emergency_call.domain.model.EmergencyCall;
import com.xxx.firstaidapplication.emergency_call.domain.model.Instruction;
import com.xxx.firstaidapplication.emergency_call.domain.repository.EmergencyCallRepository;
import com.xxx.firstaidapplication.emergency_call.domain.repository.InstructionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class InstructionService {

    private final InstructionRepository instructionRepository;
    private final EmergencyCallRepository emergencyCallRepository;

    public InstructionService(InstructionRepository instructionRepository, EmergencyCallRepository emergencyCallRepository) {
        this.instructionRepository = instructionRepository;
        this.emergencyCallRepository = emergencyCallRepository;
    }

    @Transactional
    public Instruction createInstruction(UUID emergencyCallId, Instruction instructionRequest) {
        Instruction instruction = new Instruction();
        instruction.setName(instructionRequest.getName());

        EmergencyCall emergencyCall = emergencyCallRepository.getById(emergencyCallId);
        emergencyCall.addInstruction(instruction);

        instructionRepository.save(instruction);
        emergencyCallRepository.save(emergencyCall);

        return instructionRepository.save(instruction);
    }

    @Transactional(readOnly = true)
    public List<Instruction> getInstructions(UUID emergencyCallId) {
        return instructionRepository.findAllByEmergencyCallId(emergencyCallId);
    }

    @Transactional(readOnly = true)
    public Instruction getInstruction(UUID instructionId) {
        return instructionRepository.getById(instructionId);
    }

    @Transactional
    public Instruction updateInstruction(UUID instructionId, Instruction instructionRequest) {
        Instruction instruction = instructionRepository.getById(instructionId);
        instruction.setName(instructionRequest.getName());

        return instructionRepository.save(instruction);
    }


    @Transactional
    public void deleteInstruction(UUID instructionId) {
        instructionRepository.deleteById(instructionId);
    }
}
