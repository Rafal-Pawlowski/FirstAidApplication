package com.xxx.firstaidapplication.emergency_call.service;

import com.xxx.firstaidapplication.emergency_call.domain.model.EmergencyCall;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class EmergencyCallService {


    public EmergencyCall createEmergencyCall(EmergencyCall emergencyCall) {
        emergencyCall.setId(UUID.randomUUID());

        return emergencyCall;
    }

    public List<EmergencyCall> getEmergencyCalls() {
        return Arrays.asList(new EmergencyCall("Emergency Call 1"), new EmergencyCall("Emergency Call 2"), new EmergencyCall("Emergency Call 3"));
    }


    public EmergencyCall getEmergencyCall(UUID emergencyCallId) {
        return new EmergencyCall("Emergency Call " + emergencyCallId);
    }

    public EmergencyCall updateEmergencyCall(UUID emergencyCallId, EmergencyCall emergencyCall) {
        return emergencyCall;
    }


    public void deleteEmergencyCall(UUID emergencyCallId) {
    }
}
