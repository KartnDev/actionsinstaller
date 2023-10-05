package com.company.compositiontest.view.master;

import com.company.compositiontest.entity.Master;

import com.company.compositiontest.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "masters", layout = MainView.class)
@ViewController("Master.list")
@ViewDescriptor("master-list-view.xml")
@LookupComponent("mastersDataGrid")
@DialogMode(width = "64em")
public class MasterListView extends StandardListView<Master> {
}