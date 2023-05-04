package com.example.demo.model;

import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static java.util.Objects.isNull;

@Entity
@Table(name = "internal_event")
public class InternalEvent implements Persistable<UUID> {

    @Id
    @Column(name = "id")
    private UUID id;
    @Column(name = "title")
    private String title;
    @OneToMany(mappedBy = "event", fetch = FetchType.LAZY)
    private Set<InternalAppeal> appeals;

    /* Utilities */
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<InternalAppeal> getAppeals() {
        if (appeals == null) {
            this.appeals = new HashSet<>();
        }
        return appeals;
    }

}
