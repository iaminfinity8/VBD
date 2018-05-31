/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infinity.vbd.Dao;

import com.infinity.vbd.Beans.MainClassBean;
import com.infinity.vbd.Beans.VoiceResource;
import com.infinity.vbd.Main;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import marytts.exceptions.SynthesisException;

/**
 *
 * @author Akash
 */
public class MainClass extends Application implements com.infinity.vbd.DaoInterfaces.MainClassInterface{
    private final MainClassBean mcb;
    private final ISystemTray ist;
    private boolean flag;
    private static int intFlag=90;
    private final SpeechRecognizer sr;
    private final VoiceResource vr;
    public MainClass(Stage stage) throws IOException {
        mcb=new MainClassBean();
        mcb.setVbdStage(stage);
        mcb.setMainView();
        mcb.setMainScene();
        mcb.getVbdStage().initStyle(StageStyle.TRANSPARENT);
        mcb.getVbdStage().setX(990);
        mcb.getVbdStage().setY(260);
        ist=new ISystemTray();
        mcb.setTib(ist.addSystemTray());
        mcb.getVbdStage().setScene(mcb.getMainScene());
        sr= new SpeechRecognizer();
        vr=new VoiceResource();
    }
    
    
    @Override
    public void start(Stage primaryStage) throws Exception {
         Platform.setImplicitExit(false);
        javax.swing.SwingUtilities.invokeLater(this::addTrayIcon);
        
    }

    @Override
    public void addTrayIcon() {
        
        mcb.getTib().getPopupMenu().getMenuItem().getSettingsMenuItem().addActionListener(event -> Platform.runLater(this::showSettingsScene));
        
        mcb.getTib().getPopupMenu().getMenuItem().getTakeWordMenuItem().addActionListener(event -> Platform.runLater(this::startRecognition));
    
        mcb.getTib().getPopupMenu().getMenuItem().getExitMenuItem().addActionListener(event -> Platform.runLater(this::exitApp));
    }

    @Override
    public void exitApp(){
        System.exit(0);
    }
    @Override
    public void createDummyStage() {
        Stage dummyPopup = new Stage();
        dummyPopup.initModality(Modality.NONE);   // set as utility so no iconification occurs
        dummyPopup.initStyle(StageStyle.UTILITY);   // set opacity so the window cannot be seen
        dummyPopup.setOpacity(0d);  // not necessary, but this will move the dummy stage off the screen
        final Screen screen = Screen.getPrimary();
        final Rectangle2D bounds = screen.getVisualBounds();
        dummyPopup.setX(bounds.getMaxX());
        dummyPopup.setY(bounds.getMaxY());     // create/add a transparent scene
        final Group root = new Group();
        dummyPopup.setScene(new Scene(root, 1d, 1d, Color.TRANSPARENT)); // show the dummy stage
        dummyPopup.show();
    }

    @Override
    public void startRecognition() {
        
        createDummyStage();

        TextToSpeech tts=new TextToSpeech();
        tts.setVoice(vr.getCurrentVoice());
        try {
        tts.speak("Recognition Started",1.5f,false,true);    
        } catch (InterruptedException | SynthesisException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } 
        Notification n;
        n=new Notification();
        n.showRecognitionStartedNotification();
        if(intFlag==90){
            intFlag=99;
            sr.startSpeechRecognition(); 
        }
        else
            sr.stopIgnoreSpeechRecognitionResults();
}

    @Override
    public void showSettingsScene() {
        mcb.getVbdStage().show();
    }

}