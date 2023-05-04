package com.example.demo.repository;

import com.example.demo.model.InternalEvent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.UUID;

public interface InternalEventRepository extends JpaRepository<InternalEvent, UUID> {

    @NonNull
    @Override
    @EntityGraph(attributePaths = {"appeal"})
    Page<InternalEvent> findAll(@NonNull Pageable pageable);

}
