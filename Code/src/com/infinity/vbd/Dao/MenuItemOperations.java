/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infinity.vbd.Dao;
import com.infinity.vbd.Beans.TrayIconBean;
import com.infinity.vbd.Main;
import java.awt.MenuItem;

/**
 *
 * @author Akash
 */
public final class MenuItemOperations implements com.infinity.vbd.DaoInterfaces.MenuItemOperationsInterface{
    private static MenuItem takeWordMenuItem;
    private static MenuItem settingsMenuItem;
    private static MenuItem exitMenuItem;
    TextToSpeech tts=new TextToSpeech();
    public MenuItemOperations(TrayIconBean tray) {
        takeWordMenuItem=null;
        settingsMenuItem=null;
        exitMenuItem=null;
        initiateListener(tray);
        initiateSettings(tray);
        initiateExit(tray);
    }
    @Override
    public void initiateListener(TrayIconBean tray) {
        takeWordMenuItem=tray.getPopupMenu().getMenuItem().getTakeWordMenuItem();
        takeWordMenuItem.addActionListener((e) -> {
            
        } );
    }

    @Override
    public void initiateSettings(TrayIconBean tray) {
        
        settingsMenuItem=tray.getPopupMenu().getMenuItem().getSettingsMenuItem();
        settingsMenuItem.addActionListener((e) -> {
            
        } );
    }

    @Override
    public void initiateExit(TrayIconBean tray) {
        
        exitMenuItem=tray.getPopupMenu().getMenuItem().getExitMenuItem();
        exitMenuItem.addActionListener((e) -> {
            
       } );
    }    
}
