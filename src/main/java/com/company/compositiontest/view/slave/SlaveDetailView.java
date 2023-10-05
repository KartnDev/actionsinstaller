package com.company.compositiontest.view.slave;

import com.company.compositiontest.entity.Slave;

import com.company.compositiontest.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "slaves/:id", layout = MainView.class)
@ViewController("Slave.detail")
@ViewDescriptor("slave-detail-view.xml")
@EditedEntityContainer("slaveDc")
public class SlaveDetailView extends StandardDetailView<Slave> {
}