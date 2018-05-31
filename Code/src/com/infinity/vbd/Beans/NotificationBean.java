/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infinity.vbd.Beans;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
/**
 *
 * @author Akash
 */
public final class NotificationBean {
    private Notifications recognitionStartedNotification;
    private Notifications meaningNotification;

    public NotificationBean(){
       setRecognitionStartedNotification();
        setShowmeaningNotification("al", "re");

    }
    
    public void setRecognitionStartedNotification() {
        Image img = new Image("com/infinity/vbd/Utilities/wordFound.png",true);
                recognitionStartedNotification=Notifications.create()
                .title("Voiced Based Dictionary")
                .text("Recognition Started")
                .graphic(new ImageView(img))
                .hideAfter(Duration.seconds(5))
                .darkStyle()
                .position(Pos.BOTTOM_RIGHT);
                
                 
    }

    public void setShowmeaningNotification(String word ,String meaning) {
        meaningNotification=Notifications.create()
                .title("Voiced Based Dictionary")
                .text(" Word : "+word+"\n Meaning is : "+meaning)
                .graphic(null)
                .hideAfter(Duration.seconds(5))
                .darkStyle()
                .position(Pos.BOTTOM_RIGHT);
     
        
    }

    public Notifications getRecognitionStartedNotification() {
        return recognitionStartedNotification;
    }

    public Notifications getShowmeaningNotification() {
        return meaningNotification;
    }
    
}
