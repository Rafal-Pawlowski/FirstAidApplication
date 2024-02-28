package com.xxx.firstaidapplication.emergency_call.domain.repository;

import com.xxx.firstaidapplication.emergency_call.domain.model.EmergencyCall;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EmergencyCallRepository extends JpaRepository<EmergencyCall, UUID> {
    List<EmergencyCall> findAllByCategoryId(UUID categoryId);


    @Query("from EmergencyCall e order by size(e.instructions) desc")
    Page<EmergencyCall> findTop(PageRequest pageRequest);

    @Query("from EmergencyCall e where size(e.instructions)=0")
    Page<EmergencyCall> findUnanswered(PageRequest pageRequest);
}
