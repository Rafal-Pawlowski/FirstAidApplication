package com.xxx.firstaidapplication.emergency_call.domain.repository;

import com.xxx.firstaidapplication.emergency_call.domain.model.EmergencyCall;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EmergencyCallRepository extends JpaRepository<EmergencyCall, UUID> {
    List<EmergencyCall> findAllByCategoryId(UUID categoryId);


    @Query("from EmergencyCall e order by size(e.instructions) desc")
    Page<EmergencyCall> findTop(Pageable pageable);

    @Query("from EmergencyCall e where size(e.instructions)=0")
    Page<EmergencyCall> findUnanswered(Pageable pageable);

    @Query( value = "select * from emergency_calls q where upper(q.name) like upper('%' || :query || '%')",
            countQuery= "select count(*) from emergency_calls q where upper(q.name) like upper('%' || :query || '%')",
            nativeQuery = true)
    Page<EmergencyCall> findByQuery(String query, Pageable pageable);
}

