package com.company.compositiontest.view.nslave;

import com.company.compositiontest.entity.noncomposition.NSlave;

import com.company.compositiontest.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "nSlaves/:id", layout = MainView.class)
@ViewController("NSlave.detail")
@ViewDescriptor("n-slave-detail-view.xml")
@EditedEntityContainer("nSlaveDc")
public class NSlaveDetailView extends StandardDetailView<NSlave> {
}