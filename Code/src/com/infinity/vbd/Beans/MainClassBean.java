/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infinity.vbd.Beans;

import java.awt.MenuItem;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Akash
 */
public class MainClassBean {
    private Stage VbdStage;
    private TrayIconBean tib;
    private static MenuItem takeWordMenuItem;
    private static MenuItem settingsMenuItem;
    private static MenuItem exitMenuItem;
    private Parent MainView;
    private Scene MainScene;

    public Stage getVbdStage() {
        return VbdStage;
    }

    public void setVbdStage(Stage VbdStage) {
        this.VbdStage = VbdStage;
    }

    public TrayIconBean getTib() {
        return tib;
    }

    public void setTib(TrayIconBean tib) {
        this.tib = tib;
    }

    public static MenuItem getTakeWordMenuItem() {
        return takeWordMenuItem;
    }

    public static void setTakeWordMenuItem(MenuItem takeWordMenuItem) {
        MainClassBean.takeWordMenuItem = takeWordMenuItem;
    }

    public static MenuItem getSettingsMenuItem() {
        return settingsMenuItem;
    }

    public static void setSettingsMenuItem(MenuItem settingsMenuItem) {
        MainClassBean.settingsMenuItem = settingsMenuItem;
    }

    public static MenuItem getExitMenuItem() {
        return exitMenuItem;
    }

    public static void setExitMenuItem(MenuItem exitMenuItem) {
        MainClassBean.exitMenuItem = exitMenuItem;
    }

    public Parent getMainView() {
        return MainView;
    }

    public void setMainView() throws IOException {
        this.MainView = FXMLLoader.load(getClass().getResource("/com/infinity/vbd/FXML/MainFXMLDocument.fxml"));
    }

    public Scene getMainScene() {
        return MainScene;
    }

    public void setMainScene() {
        this.MainScene=new Scene(getMainView());
    }
    
}
