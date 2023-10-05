package com.company.compositiontest.view.nmaster;

import com.company.compositiontest.entity.Slave;
import com.company.compositiontest.entity.noncomposition.NMaster;

import com.company.compositiontest.entity.noncomposition.NSlave;
import com.company.compositiontest.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.core.Metadata;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "nMastersDetail/:id", layout = MainView.class)
@ViewController("NMaster.detail")
@ViewDescriptor("n-master-detail-view.xml")
@EditedEntityContainer("nMasterDc")
public class NMasterDetailView extends StandardDetailView<NMaster> {
    @Autowired
    private Metadata metadata;

    @Install(to = "slavesGrid.create", subject = "initializer")
    private void slavesGridCreateInitializer(final NSlave slave) {
        slave.setNMaster(getEditedEntity());
    }

    @Install(to = "slavesGrid.create", subject = "transformation")
    private NSlave slavesGridCreateTransformation(final NSlave nSlave) {
        nSlave.setNMaster(getEditedEntity());
        return nSlave;
    }

    @Install(to = "slavesGrid.create", subject = "newEntitySupplier")
    private NSlave slavesGridCreateNewEntitySupplier() {
        NSlave nSlave = metadata.create(NSlave.class);
        nSlave.setNMaster(getEditedEntity());
        return nSlave;
    }

}