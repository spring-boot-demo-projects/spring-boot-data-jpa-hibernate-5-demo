package com.example.demo.repository;

import com.example.demo.model.InternalAppeal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.UUID;

public interface InternalAppealRepository extends JpaRepository<InternalAppeal, UUID> {

    @NonNull
    @Override
    @EntityGraph(attributePaths = {"event"})
    Page<InternalAppeal> findAll(@NonNull Pageable pageable);

}
