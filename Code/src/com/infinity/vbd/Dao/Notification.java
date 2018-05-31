/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infinity.vbd.Dao;

import com.infinity.vbd.Beans.NotificationBean;
import javafx.geometry.Pos;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 *
 * @author Akash
 */
public class Notification implements com.infinity.vbd.DaoInterfaces.NotificationInterface{
    private final NotificationBean notificationBean;

    public Notification() {
        notificationBean=new NotificationBean();
       // notificationBean.setRecognitionStartedNotification();
        //notificationBean.setShowmeaningNotification("heelo"," meaning");
    }
    
    
    
    @Override
    public void showRecognitionStartedNotification() {
        Notifications temp=notificationBean.getRecognitionStartedNotification();
                temp.show();
               // wait()
    }

    @Override
    public synchronized void showMeaningNotification(String word,String meaning) {
        Notifications temp;
        temp = notificationBean.getShowmeaningNotification();
        temp.show();
        notifyAll();
    }
    
}
