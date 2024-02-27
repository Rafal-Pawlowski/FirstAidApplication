package com.xxx.firstaidapplication.emergency_call.domain.repository;

import com.xxx.firstaidapplication.emergency_call.domain.model.EmergencyCall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EmergencyCallRepository extends JpaRepository<EmergencyCall, UUID> {
    List<EmergencyCall> findAllByCategoryId(UUID categoryId);




}
