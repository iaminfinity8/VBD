/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infinity.vbd.Dao;

import com.infinity.vbd.Beans.ISystemTrayBean;
import com.infinity.vbd.Beans.TrayIconBean;
import com.infinity.vbd.DaoInterfaces.ISystemTrayInterface;
import java.awt.AWTException;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Shubham
 */
public class ISystemTray implements ISystemTrayInterface{
    
    @Override
    public TrayIconBean addSystemTray() {
        TrayIconBean tib=new TrayIconBean();
        ISystemTrayBean istb=new ISystemTrayBean();
        SystemTray st= istb.getSystemTray();
        try {            
            st.add(tib.getTrayIcon());
        } catch (AWTException ex) {
            Logger.getLogger(ISystemTray.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tib;
    }
    
}
