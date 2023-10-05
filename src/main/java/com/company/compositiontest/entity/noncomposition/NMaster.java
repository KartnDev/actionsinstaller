package com.company.compositiontest.entity.noncomposition;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@JmixEntity
@Table(name = "N_MASTER")
@Entity
public class NMaster {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @InstanceName
    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "nMaster")
    private List<NSlave> nslaves;

    public List<NSlave> getNslaves() {
        return nslaves;
    }

    public void setNslaves(List<NSlave> nslaves) {
        this.nslaves = nslaves;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}