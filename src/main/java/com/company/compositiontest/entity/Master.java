package com.company.compositiontest.entity;

import io.jmix.core.Metadata;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@JmixEntity
@Table(name = "MASTER")
@Entity
public class Master {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "INITIALIZED_BY_POST_CONSTRUCT")
    private String initializedByPostConstruct;

    @InstanceName
    @Column(name = "NAME")
    private String name;

    @Composition
    @OneToMany(mappedBy = "master")
    private List<Slave> slaves;

    public List<Slave> getSlaves() {
        return slaves;
    }

    public void setSlaves(List<Slave> slaves) {
        this.slaves = slaves;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInitializedByPostConstruct() {
        return initializedByPostConstruct;
    }

    public void setInitializedByPostConstruct(String initializedByPostConstruct) {
        this.initializedByPostConstruct = initializedByPostConstruct;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @PostConstruct
    public void postConstruct(Metadata metadata) {
        if(metadata != null) {
            setInitializedByPostConstruct(metadata.toString());
        }
    }
}