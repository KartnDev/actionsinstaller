package com.company.compositiontest.view.master;

import com.company.compositiontest.entity.Master;

import com.company.compositiontest.entity.Slave;
import com.company.compositiontest.entity.noncomposition.NSlave;
import com.company.compositiontest.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.core.Metadata;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "mastersdetail/:id", layout = MainView.class)
@ViewController("Master.detail")
@ViewDescriptor("master-detail-view.xml")
@EditedEntityContainer("masterDc")
public class MasterDetailView extends StandardDetailView<Master> {
    @Autowired
    private Metadata metadata;

    @Install(to = "slavesGrid.create", subject = "initializer")
    private void slavesGridCreateInitializer(final Slave slave) {
        slave.setMaster(getEditedEntity());
    }

    @Install(to = "slavesGrid.create", subject = "transformation")
    private Slave slavesGridCreateTransformation(final Slave nSlave) {
        nSlave.setMaster(getEditedEntity());
        return nSlave;
    }

    @Install(to = "slavesGrid.create", subject = "newEntitySupplier")
    private Slave slavesGridCreateNewEntitySupplier() {
        Slave slave = metadata.create(Slave.class);
        slave.setMaster(getEditedEntity());
        return slave;
    }
}