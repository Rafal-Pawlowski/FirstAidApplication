package com.xxx.firstaidapplication.emergency_call.domain.repository;

import com.xxx.firstaidapplication.emergency_call.domain.model.Instruction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface InstructionRepository extends JpaRepository<Instruction, UUID> {
    List<Instruction> findAllByEmergencyCallId(UUID emergencyCallId);
}
