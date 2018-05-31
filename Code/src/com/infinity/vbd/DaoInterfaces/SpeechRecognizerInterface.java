/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infinity.vbd.DaoInterfaces;

import edu.cmu.sphinx.result.WordResult;
import java.util.List;
import javafx.beans.property.SimpleBooleanProperty;

/**
 *
 * @author Akash
 */
public interface SpeechRecognizerInterface {
    public void startSpeechRecognition();
    public void stopIgnoreSpeechRecognitionResults();
    public void ignoreSpeechRecognitionResults();
    public void startResourcesThread();
    public void makeDecision(String speech , List<WordResult> speechWords);
    public SimpleBooleanProperty ignoreSpeechRecognitionResultsProperty();
    public SimpleBooleanProperty speechRecognizerThreadRunningProperty();
}
