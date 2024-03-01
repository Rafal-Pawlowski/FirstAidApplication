package com.xxx.firstaidapplication.emergency_call.service;

import com.xxx.firstaidapplication.emergency_call.domain.model.EmergencyCall;
import com.xxx.firstaidapplication.emergency_call.domain.repository.EmergencyCallRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class EmergencyCallService {

    private final EmergencyCallRepository emergencyCallRepository;

    public EmergencyCallService(EmergencyCallRepository emergencyCallRepository) {
        this.emergencyCallRepository = emergencyCallRepository;
    }

    @Transactional
    public EmergencyCall createEmergencyCall(EmergencyCall emergencyCallRequest) {
        EmergencyCall emergencyCall = new EmergencyCall();
        emergencyCall.setName(emergencyCallRequest.getName());

        return emergencyCallRepository.save(emergencyCall);
    }

    @Transactional(readOnly = true)
    public List<EmergencyCall> getEmergencyCalls() {
        return emergencyCallRepository.findAll();
    }

    @Transactional(readOnly = true)
    public EmergencyCall getEmergencyCall(UUID emergencyCallId) {
        return emergencyCallRepository.getById(emergencyCallId);
    }

    @Transactional
    public EmergencyCall updateEmergencyCall(UUID emergencyCallId, EmergencyCall emergencyCallRequest) {
        EmergencyCall emergencyCall = emergencyCallRepository.getById(emergencyCallId);
        emergencyCall.setName(emergencyCallRequest.getName());

        return emergencyCallRepository.save(emergencyCall);
    }

    @Transactional
    public void deleteEmergencyCall(UUID emergencyCallId) {
        emergencyCallRepository.deleteById(emergencyCallId);
    }

    @Transactional(readOnly = true)
    public List<EmergencyCall> findAllEmergencyCallsByCategoryId(UUID CategoryId) {
        return emergencyCallRepository.findAllByCategoryId(CategoryId);
    }


    @Transactional(readOnly = true)
    public Page<EmergencyCall> findTop(Pageable pageable) {
    return emergencyCallRepository.findTop(pageable);
    }

    @Transactional(readOnly = true)
    public Page<EmergencyCall> findUnanswered(Pageable pageable) {
        return emergencyCallRepository.findUnanswered(pageable);
    }

    public Page<EmergencyCall> findByQuery(String query, Pageable pageable) {
        return emergencyCallRepository.findByQuery(query, pageable);
    }
}
