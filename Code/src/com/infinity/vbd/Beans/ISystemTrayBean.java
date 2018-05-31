/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infinity.vbd.Beans;

import java.awt.SystemTray;

/**
 *
 * @author Shubham
 */
public class ISystemTrayBean {
    private SystemTray systemTray;

    public ISystemTrayBean() {
        systemTray=SystemTray.getSystemTray();
    }

    public SystemTray getSystemTray() {
        return systemTray;
    }
    
    
}
