package com.company.compositiontest.entity.noncomposition;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;

import java.util.UUID;

@JmixEntity
@Table(name = "N_SLAVE", indexes = {
        @Index(name = "IDX_N_SLAVE_N_MASTER", columnList = "N_MASTER_ID")
})
@Entity
public class NSlave {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @InstanceName
    @Column(name = "NAME")
    private String name;
    @JoinColumn(name = "N_MASTER_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private NMaster nMaster;

    public NMaster getNMaster() {
        return nMaster;
    }

    public void setNMaster(NMaster nMaster) {
        this.nMaster = nMaster;
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