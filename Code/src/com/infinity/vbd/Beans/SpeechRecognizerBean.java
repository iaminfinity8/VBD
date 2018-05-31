/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infinity.vbd.Beans;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javafx.beans.property.SimpleBooleanProperty;

/**
 *
 * @author Akash
 */
public class SpeechRecognizerBean {
    private final LiveSpeechRecognizer recognizer;
    private String speechRecognitionResult;
    private final SimpleBooleanProperty ignoreSpeechRecognitionResults;
    private final SimpleBooleanProperty speechRecognizerThreadRunning;
    private boolean resourcesThreadRunning;
    private final ExecutorService eventsExecutorService;
    Configuration configuration;
    SpeechResult result;

    public SpeechRecognizerBean() throws IOException{
        ignoreSpeechRecognitionResults= new SimpleBooleanProperty(false);
        speechRecognizerThreadRunning  = new SimpleBooleanProperty(false);
        eventsExecutorService  = Executors.newFixedThreadPool(2);
        configuration = new Configuration();
        configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
        configuration.setDictionaryPath("6708.dic");
        configuration.setLanguageModelPath("6708.lm");
        recognizer = new LiveSpeechRecognizer(configuration);
    }

    public void setResourcesThreadRunning(boolean resourcesThreadRunning) {
        this.resourcesThreadRunning = resourcesThreadRunning;
    }

    public void setSpeechRecognitionResult(String speechRecognitionResult) {
        this.speechRecognitionResult = speechRecognitionResult;
    }
    
    public void setResult(SpeechResult result) {
        this.result = result;
    }
    
    public LiveSpeechRecognizer getRecognizer() {
        return recognizer;
    }

    public String getSpeechRecognitionResult() {
        return speechRecognitionResult;
    }

    public SimpleBooleanProperty getIgnoreSpeechRecognitionResults() {
        return ignoreSpeechRecognitionResults;
    }

    public SimpleBooleanProperty getSpeechRecognizerThreadRunning() {
        return speechRecognizerThreadRunning;
    }

    public boolean isResourcesThreadRunning() {
        return resourcesThreadRunning;
    }

    public ExecutorService getEventsExecutorService() {
        return eventsExecutorService;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public SpeechResult getResult() {
        return result;
    }
    
    
    
}
