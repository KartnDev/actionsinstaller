package com.company.compositiontest.view.nmaster;

import com.company.compositiontest.entity.noncomposition.NMaster;

import com.company.compositiontest.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "nMasters", layout = MainView.class)
@ViewController("NMaster.list")
@ViewDescriptor("n-master-list-view.xml")
@LookupComponent("nMastersDataGrid")
@DialogMode(width = "64em")
public class NMasterListView extends StandardListView<NMaster> {
}