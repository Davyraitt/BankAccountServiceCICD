package com.davyraitt.DataAccess_Repository_Layer.database.entitys;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @Type(type = "uuid-char")
    @GeneratedValue
    private UUID id;

    @Version
    private Long version;

    @CreationTimestamp
    private LocalDateTime created;
    @UpdateTimestamp
    private LocalDateTime lastModified;

    public BaseEntity() {
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "id=" +
                ", version=" + version +
                ", created=" + created +
                ", lastModified=" + lastModified +
                '}';
    }

    public Long getVersion() {
        return version;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getLastModified() {
        return lastModified;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public void setLastModified(LocalDateTime lastModified) {
        this.lastModified = lastModified;
    }
}
