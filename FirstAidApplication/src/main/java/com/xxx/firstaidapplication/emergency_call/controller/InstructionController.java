package com.xxx.firstaidapplication.emergency_call.controller;

import com.xxx.firstaidapplication.emergency_call.domain.model.Instruction;
import com.xxx.firstaidapplication.emergency_call.service.InstructionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/emergency-calls/{emergency-call-id}/instructions")
public class InstructionController {

    /**
     * C - create
     *  POST /api/v1/emergency-calls/{emergency-call-id}/instructions
     *
     * R - read
     *  GET /api/v1/emergency-calls/{emergency-call-id}/instructions
     *  GET /api/v1/emergency-calls/{emergency-call-id}/instructions/{instruction-id}
     *
     * U - update
     *  PUT /api/v1/emergency-calls/{emergency-call-id}/instructions/{instruction-id}
     *
     * D - delete
     *  DELETE /api/v1/emergency-calls/{emergency-call-id}/instructions/{instruction-id}
     *
     */

    private final InstructionService instructionService;

    public InstructionController(InstructionService instructionService) {
        this.instructionService = instructionService;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Instruction createInstruction(@PathVariable("emergency-call-id") UUID emergencyCallId, @RequestBody Instruction instruction){
        return instructionService.createInstruction(emergencyCallId, instruction);
    }

    @GetMapping
    List<Instruction> getInstructions(@PathVariable("emergency-call-id") UUID emergencyCallId){
        return instructionService.getInstructions(emergencyCallId);
    }

    @GetMapping("{instruction-id}")
    Instruction getInstruction(@PathVariable("emergency-call-id") UUID emergencyCallId,
                               @PathVariable("instruction-id") UUID instructionId){
        return instructionService.getInstruction(instructionId);
    }

    @PutMapping("{instruction-id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    Instruction updateInstruction(@PathVariable("instruction-id") UUID instructionId,
                                  @PathVariable("emergency-call-id") UUID emergencyCallId,
                                  @RequestBody Instruction instruction){
        return instructionService.updateInstruction(instructionId,  instruction);
    }

    @DeleteMapping("{instruction-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteInstruction(@PathVariable("instruction-id") UUID instructionId, @PathVariable("emergency-call-id") UUID emergencyCallId){
        instructionService.deleteInstruction(instructionId);
    }





}
