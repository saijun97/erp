package com.company.erp.web.screens.general.respsidemenu;

import com.company.erp.web.screens.general.dashboards.DashboardScreen;
import com.haulmont.addon.dashboard.model.Dashboard;
import com.haulmont.cuba.gui.ScreenBuilders;

import com.haulmont.cuba.gui.Screens;
import com.haulmont.cuba.gui.components.mainwindow.AppWorkArea;
import com.haulmont.cuba.gui.components.mainwindow.SideMenu;

import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.web.app.main.MainScreen;
import com.haulmont.cuba.web.gui.components.mainwindow.WebAppWorkArea;

import javax.inject.Inject;


import java.util.function.Consumer;

import static com.haulmont.cuba.gui.components.mainwindow.AppWorkArea.State.INITIAL_LAYOUT;


@UiController("extMainScreen")
@UiDescriptor("ext-main-screen.xml")
@LoadDataBeforeShow
public class ExtMainScreen extends MainScreen {


}