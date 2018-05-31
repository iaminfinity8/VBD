/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infinity.vbd.DaoInterfaces;

import com.infinity.vbd.Beans.TrayIconBean;

/**
 *
 * @author Akash
 */
public interface MenuItemOperationsInterface {
    public void initiateListener(TrayIconBean tray);
    public void initiateSettings(TrayIconBean tray);
    public void initiateExit(TrayIconBean tray);
    
}
