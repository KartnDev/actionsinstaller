package com.company.compositiontest.entity;

import io.jmix.core.DeletePolicy;
import io.jmix.core.Metadata;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.*;

import java.util.UUID;

@JmixEntity
@Table(name = "SLAVE", indexes = {
        @Index(name = "IDX_SLAVE_MASTER", columnList = "MASTER_ID")
})
@Entity
public class Slave {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "INITIALIZED_BY_POST_CONSTRUCT")
    private String initializedByPostConstruct;

    @Column(name = "SLAVE_NAME")
    private String slaveName;
    @OnDeleteInverse(DeletePolicy.CASCADE)
    @JoinColumn(name = "MASTER_ID", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Master master;

    public Master getMaster() {
        return master;
    }

    public void setMaster(Master master) {
        this.master = master;
    }

    public String getSlaveName() {
        return slaveName;
    }

    public void setSlaveName(String slaveName) {
        this.slaveName = slaveName;
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