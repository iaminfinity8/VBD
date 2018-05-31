/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infinity.vbd.Beans;

import java.awt.PopupMenu;

/**
 *
 * @author Shubham
 */
public class PopupMenuBean {
    private final PopupMenu popupMenu;
    private final MenuItemBean menuItem;

    public PopupMenuBean() {
       popupMenu=new PopupMenu();
       menuItem=new MenuItemBean();
       popupMenu.add(menuItem.getTakeWordMenuItem());
       popupMenu.add(menuItem.getSettingsMenuItem());
       popupMenu.addSeparator();
       popupMenu.add(menuItem.getExitMenuItem());
    }

    public MenuItemBean getMenuItem() {
        return menuItem;
    }

    public PopupMenu getPopupMenu() {
        return popupMenu;
    }
}
