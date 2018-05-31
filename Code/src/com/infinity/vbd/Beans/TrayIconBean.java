/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infinity.vbd.Beans;

import java.awt.Toolkit;
import java.awt.TrayIcon;



/**
 *
 * @author Shubham
 */
public class TrayIconBean {
    private final TrayIcon trayIcon;
    private final PopupMenuBean popupMenu;
    private final Toolkit toolkit;

    public TrayIconBean() {
        popupMenu=new PopupMenuBean();
        toolkit=Toolkit.getDefaultToolkit();
        trayIcon=new TrayIcon(toolkit.getImage("src/com/infinity/vbd/Utilities/SystemTray.png"));
        trayIcon.setToolTip("Voice Based Dictionary\nVer 1.0.0");
        trayIcon.setPopupMenu(popupMenu.getPopupMenu());
    }

    public TrayIcon getTrayIcon() {
        return trayIcon;
    }

    public PopupMenuBean getPopupMenu() {
        return popupMenu;
    }

    public Toolkit getToolkit() {
        return toolkit;
    }
}
