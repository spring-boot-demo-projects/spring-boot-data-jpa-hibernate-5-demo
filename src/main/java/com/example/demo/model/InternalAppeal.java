package com.example.demo.model;

import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.util.UUID;

import static java.util.Objects.isNull;

@Entity
@SuppressWarnings("unused")
@Table(name = "internal_appeal")
public class InternalAppeal implements Persistable<UUID> {

    @Id
    @Column(name = "id")
    private UUID id;
    @JoinColumn(name = "event_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private InternalEvent event;

    @Override
    public boolean isNew() {
        return isNull(id);
    }

    /* Getters and setters */
    @Override
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public InternalEvent getEvent() {
        return event;
    }

    public void setEvent(InternalEvent event) {
        this.event = event;
    }

}
