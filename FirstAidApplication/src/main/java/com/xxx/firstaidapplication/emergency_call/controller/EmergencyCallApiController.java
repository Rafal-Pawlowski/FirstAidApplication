package com.xxx.firstaidapplication.emergency_call.controller;


import com.xxx.firstaidapplication.emergency_call.service.EmergencyCallService;
import com.xxx.firstaidapplication.emergency_call.domain.model.EmergencyCall;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/emergency-calls")
public class EmergencyCallApiController {


    /**
     * C - create
     *  POST /emergency-calls
     *
     * R - read
     *  GET /emergency-calls
     *  GET /emergency-calls/{emergency-call-id}
     *
     * U - update
     *  PUT /emergency-calls/{emergency-call-id}
     *
     * D - delete
     *  DELETE/emergency-calls/{emergency-call-id}
     *
     */

    private final EmergencyCallService emergencyCallService;


    public EmergencyCallApiController(EmergencyCallService emergencyCallService) {
        this.emergencyCallService = emergencyCallService;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    EmergencyCall createEmergencyCall(@RequestBody EmergencyCall emergencyCall){
        return emergencyCallService.createEmergencyCall(emergencyCall);
    }

    @GetMapping()
    List<EmergencyCall> getEmergencyCalls(){
        return emergencyCallService.getEmergencyCalls();
    }

    @GetMapping("{emergency-call-id}")
    EmergencyCall getEmergencyCall(@PathVariable("emergency-call-id")UUID emergencyCallId){
        return emergencyCallService.getEmergencyCall(emergencyCallId);
    }

    @PutMapping("{emergency-call-id}")
    @ResponseStatus(HttpStatus.OK)
    EmergencyCall updateEmergencyCall(@PathVariable("emergency-call-id")UUID emergencyCallId,
                                      @RequestBody EmergencyCall emergencyCall){
        return emergencyCallService.updateEmergencyCall(emergencyCallId, emergencyCall);
    }

    @DeleteMapping("{emergency-call-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteEmergencyCall(@PathVariable("emergency-call-id")UUID emergencyCallId){
        emergencyCallService.deleteEmergencyCall(emergencyCallId);
    }






}
