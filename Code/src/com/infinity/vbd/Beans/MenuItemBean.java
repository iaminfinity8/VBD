/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infinity.vbd.Beans;

import java.awt.MenuItem;
/* 
            java.awt.Font defaultFont = java.awt.Font.decode(null);
            java.awt.Font boldFont = defaultFont.deriveFont(java.awt.Font.BOLD);
            openItem.setFont(boldFont);
*/

public class MenuItemBean {
        private final MenuItem takeWordMenuItem;
        private final MenuItem settingsMenuItem;
        private final MenuItem exitMenuItem;

    public MenuItemBean() {
        java.awt.Font defaultFont = java.awt.Font.decode(null);
            java.awt.Font boldFont = defaultFont.deriveFont(java.awt.Font.BOLD);
        takeWordMenuItem=new MenuItem("Take Word");
        takeWordMenuItem.setFont(boldFont);
        settingsMenuItem=new MenuItem("Open");
        exitMenuItem=new MenuItem("Exit");
    }
    
    
    public MenuItem getTakeWordMenuItem() {
        return takeWordMenuItem;
    }

    public MenuItem getSettingsMenuItem() {
        return settingsMenuItem;
    }
    public MenuItem getExitMenuItem() {
        return exitMenuItem;
    }       
}