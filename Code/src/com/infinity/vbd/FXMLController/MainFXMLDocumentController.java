/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infinity.vbd.FXMLController;

import com.infinity.vbd.Beans.VoiceResource;
import com.infinity.vbd.Dao.Search;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSlider;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Akash
 */
public class MainFXMLDocumentController implements Initializable {

    @FXML
    private AnchorPane anchorPaneMainInfinity;

    @FXML
    private ImageView buttonInfinityMinimize;
    @FXML
    private AnchorPane anchorPaneInfinityInformation;
    @FXML
    private AnchorPane anchorPaneInfinitySettings;
    @FXML
    private ImageView buttonBInfinityHome;
    @FXML
    private ImageView buttonInfinityHome;
    @FXML
    private ImageView buttonInfinitySettings;
    @FXML
    private ImageView buttonInfinityInformation;
    @FXML
    private ImageView buttonInfinityHelp;
    @FXML
    private ImageView buttonBInfinitySettings;
    @FXML
    private ImageView buttonBInfinityInformation;
    @FXML
    private ImageView buttonBInfinityHelp;
    @FXML
    private AnchorPane anchorPaneInfinityHome;
    @FXML
    private AnchorPane anchorPaneInfinityHomeResultDisplay;
    @FXML
    private Label resultLabel;
    @FXML
    private Label resultDetailsLabel;
    @FXML
    private AnchorPane anchorPaneInfinityHomeSearch;
    @FXML
    private ImageView buttonInfinitySearchMeaning;
    @FXML
    private JFXTextField inputWord;
    @FXML
    private AnchorPane anchorPaneInfinityHelp;
    @FXML
    private JFXButton saveButton;
    @FXML
    private JFXSlider voiceSlider;
    @FXML
    private Label history_wordlist_label;
    
    private Search search;
    private VoiceResource vr;
    
    @FXML
    private AnchorPane anchorPaneInfinityHistory;
    @FXML
    private ImageView buttonInfinityHistory;
    @FXML
    private ImageView buttonBInfinityHistory;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            search=new Search();
            vr=new VoiceResource();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(MainFXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        voiceSlider.setValue(0);
        
    }    

    @FXML
    private void minimizeInfinityHome(MouseEvent event) {
          Stage stage = (Stage) buttonInfinityMinimize.getScene().getWindow();
        stage.hide();
    }

    @FXML
    private void showAnchorPaneInfinityHome(MouseEvent event) {
            buttonBInfinityHome.setVisible(true);
            buttonBInfinitySettings.setVisible(false);
            buttonBInfinityInformation.setVisible(false);
            buttonBInfinityHelp.setVisible(false);
            buttonBInfinityHistory.setVisible(false);
            anchorPaneInfinitySettings.setVisible(false);
            anchorPaneInfinityHome.setVisible(true);
            anchorPaneInfinityHelp.setVisible(false);
    }

    @FXML
    private void showAnchorPaneInfinitySettings(MouseEvent event) {
            buttonBInfinityHome.setVisible(false);
            buttonBInfinitySettings.setVisible(true);
            buttonBInfinityInformation.setVisible(false);
            buttonBInfinityHistory.setVisible(false);
            buttonBInfinityHelp.setVisible(false);
            anchorPaneInfinitySettings.setVisible(true);
            anchorPaneInfinityHome.setVisible(false);
            anchorPaneInfinityHistory.setVisible(false);
            anchorPaneInfinityHelp.setVisible(false);
    }
    
    @FXML
    private void showAnchorPaneInfinityHistory(MouseEvent event){
        
            buttonBInfinityHome.setVisible(false);
            buttonBInfinitySettings.setVisible(false);
            buttonBInfinityHistory.setVisible(true);
            buttonBInfinityInformation.setVisible(false);
            buttonBInfinityHelp.setVisible(false);
            anchorPaneInfinitySettings.setVisible(false);
            anchorPaneInfinityHistory.setVisible(true);
            anchorPaneInfinityHome.setVisible(false);
            anchorPaneInfinityHelp.setVisible(false);
    }

    @FXML
    private void showAnchorPaneInfinityInformation(MouseEvent event) {
            
            buttonBInfinityHome.setVisible(false);
            buttonBInfinitySettings.setVisible(false);
             buttonBInfinityHistory.setVisible(false);
            buttonBInfinityInformation.setVisible(true);
            buttonBInfinityHelp.setVisible(false);
            anchorPaneInfinityInformation.setVisible(true);
            anchorPaneInfinityHome.setVisible(false);
            anchorPaneInfinitySettings.setVisible(false);
            anchorPaneInfinityHelp.setVisible(false);
            anchorPaneInfinityHistory.setVisible(false);
    }

    @FXML
    private void showAnchorPaneInfinityHelp(MouseEvent event) {
            anchorPaneInfinityInformation.setVisible(false);
            anchorPaneInfinityHelp.setVisible(true);
            buttonBInfinityHome.setVisible(false);
            buttonBInfinitySettings.setVisible(false);
            buttonBInfinityInformation.setVisible(false);
             buttonBInfinityHistory.setVisible(false);
            buttonBInfinityHelp.setVisible(true);
            anchorPaneInfinityInformation.setVisible(false);
            anchorPaneInfinityHome.setVisible(false);
            anchorPaneInfinityHistory.setVisible(false);
            anchorPaneInfinitySettings.setVisible(false);
    }

    @FXML
    private void showResultOfSearch(MouseEvent event) {
       
        if(inputWord.getText().equals("")){
           resultLabel.setText("ERROR :");
           resultLabel.setTextFill(Color.RED);
           resultDetailsLabel.setText("Please enter word first...");
        }else if(search.searchMeaning(inputWord.getText())){
            System.out.println("alala");
            resultLabel.setTextFill(Color.web("#ddd2d2"));
            resultLabel.setText("Meaning :");
            resultDetailsLabel.setText(search.getMeaning(inputWord.getText()));
        }else if(!search.searchMeaning(inputWord.getText())){
           resultLabel.setText("ERROR :");
           resultLabel.setTextFill(Color.RED);
           resultDetailsLabel.setText("Word not Found in Dictionary");
        }
            anchorPaneInfinityHomeResultDisplay.setVisible(true);
            anchorPaneInfinityInformation.setVisible(false);
            anchorPaneInfinityHome.setVisible(true);
            anchorPaneInfinitySettings.setVisible(false);
            anchorPaneInfinityHelp.setVisible(false);
    }
    @FXML
    private void saveVoiceResource(MouseEvent event) throws IOException{
       int  voiceValue=(int)voiceSlider.getValue();
       switch(voiceValue){
            case 0: vr.setCurrentVoice("cmu-rms-hsmm");
                System.out.println("zero");
                break;
            case 25: vr.setCurrentVoice("dfki-poppy-hsmm");
                break; 
            case 50: vr.setCurrentVoice("dfki-spike-hsmm");
                break;
            case 75: vr.setCurrentVoice("cmu-bdl-hsmm");
                break;
            case 100: vr.setCurrentVoice("dfki-obadiah-hsmm");
                break;
            default :
                vr.setCurrentVoice("cmu-rms-hsmm");
                break;
       }
    }
}
