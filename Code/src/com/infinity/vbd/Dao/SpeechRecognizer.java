/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infinity.vbd.Dao;

import com.infinity.vbd.Beans.SearchBean;
import com.infinity.vbd.Beans.SpeechRecognizerBean;
import com.infinity.vbd.Beans.VoiceResource;
import edu.cmu.sphinx.result.WordResult;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.property.SimpleBooleanProperty;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Port;
import marytts.exceptions.SynthesisException;

/**
 *
 * @author Akash
 */
public class SpeechRecognizer implements com.infinity.vbd.DaoInterfaces.SpeechRecognizerInterface{
    private final SpeechRecognizerBean srb;
    private final TextToSpeech tts;
    private final VoiceResource vr;

        
    public SpeechRecognizer() throws IOException{
        srb=new SpeechRecognizerBean();
        tts=new TextToSpeech();
        vr=new VoiceResource();
//tts.setVoice(vr.getCurrentVoice());

    }
    @Override
    public synchronized void startSpeechRecognition() {
        srb.getEventsExecutorService().submit(() -> {		
            //locks
            Platform.runLater(() -> {
                    srb.getSpeechRecognizerThreadRunning().set(true); // Turn On Speech Recognition
                    srb.getIgnoreSpeechRecognitionResults().set(false); // ignore all results of Speech Recognition
                   // System.out.println(ignoreSpeechRecognitionResultsProperty());
            });
            //Start Recognition
            srb.getRecognizer().startRecognition(true);
                   
            try {
                tts.setVoice(vr.getCurrentVoice());
                tts.speak("Speak Now", 1.5f, true, true);
                    while (srb.getSpeechRecognizerThreadRunning().get()) {
                            /*
                             * This method will return when the end of speech is reached. Note that the end pointer will determine the end of speech.
                             */
                            srb.setResult(srb.getRecognizer().getResult());

                            //Check if we ignore the speech recognition results
                            if (!srb.getIgnoreSpeechRecognitionResults().get() || srb.getResult().getHypothesis().equalsIgnoreCase("OPEN DICTIONARY")) {
                                
                                if(srb.getResult().getHypothesis().equalsIgnoreCase("OPEN DICTIONARY")){ // OPEN DICTIONARY is command for interfacing
                                
                                srb.getRecognizer().stopRecognition();
                                tts.setVoice(vr.getCurrentVoice());
                                tts.speak("Speak Now", 1.5f, true, true);
                                srb.getRecognizer().startRecognition(true);
                                srb.setResult(srb.getRecognizer().getResult());
                                
                                }//Check the result
                                 
                                    if (srb.getResult() == null ) // If result is Empty
                                            System.out.println("I can't understand what you said.\n");
                                    else {
                                            String foundWord;
                                            Search S=new Search();
                                            
                                            //Get the hypothesis
                                            srb.setSpeechRecognitionResult(srb.getResult().getHypothesis());
                                            foundWord=(srb.getSpeechRecognitionResult()).toLowerCase();
                                            if(S.searchMeaning(foundWord)){
                                                ignoreSpeechRecognitionResults();
                                                
                                                SearchBean.setFoundWord(foundWord); // set found word to a variable "FoundWord"
                                                SearchBean.setFoundMeaning(S.getMeaning(foundWord)); // set found Meaning to a variable "FoundMeaning"
                                                //System.out.println(foundWord); // Disply found Word on Console
                                                tts.setVoice(vr.getCurrentVoice());
                                                tts.speak("Meaning of "+SearchBean.getFoundWord()+" is "+SearchBean.getFoundMeaning(), 1.5f, true, true);
                                                SearchBean.setFoundWord(null);
                                                SearchBean.setFoundMeaning(null);

                                            }
                                            else{
                                                    tts.setVoice(vr.getCurrentVoice());
                                                    tts.speak("Meaning of "+SearchBean.getFoundWord()+" could not be found", 1.5f, true, true);
                                                    SearchBean.setFoundWord(null);
                                                    SearchBean.setFoundMeaning(null);
                                            }
                                    }
                            } else
                                    System.out.println("Ignoring Speech Recognition Results...");
                    }
                    //ignoreSpeechRecognitionResults();
            } catch (IOException | ClassNotFoundException ex) {
                    Platform.runLater(() -> srb.getSpeechRecognizerThreadRunning().set(false));
            } catch (InterruptedException | SynthesisException ex) {
                Logger.getLogger(SpeechRecognizer.class.getName()).log(Level.SEVERE, null, ex);
            }});
    }

    @Override
    public synchronized void stopIgnoreSpeechRecognitionResults() {
        //Stop ignoring speech recognition results
	Platform.runLater(() -> srb.getIgnoreSpeechRecognitionResults().set(false));
    }

    @Override
    public synchronized void ignoreSpeechRecognitionResults(){ 
            //Instead of stopping the speech recognition we are ignoring it's results
            Platform.runLater(() -> srb.getIgnoreSpeechRecognitionResults().set(true));
    }

    @Override
    public void startResourcesThread() {
        srb.getEventsExecutorService().submit(() -> {
            try {

                        //Lock
                        srb.setResourcesThreadRunning(true);

                        // Detect if the microphone is available
                        while (true) {

                                //Is the Microphone Available
                                if (!AudioSystem.isLineSupported(Port.Info.MICROPHONE))
                                       System.out.println("Microphone is not available.\n");

                                // Sleep some period
                                Thread.sleep(350);
                        }

                } catch (InterruptedException ex) {
                        //logger.log(Level.WARNING, null, ex);
                        srb.setResourcesThreadRunning(false);
                }
        });
    }

    @Override
    public void makeDecision(String speech, List<WordResult> speechWords) {
        System.out.println(speech);
    }

    @Override
    public SimpleBooleanProperty ignoreSpeechRecognitionResultsProperty() {
        return srb.getIgnoreSpeechRecognitionResults();
    }

    @Override
    public SimpleBooleanProperty speechRecognizerThreadRunningProperty() {
        return srb.getSpeechRecognizerThreadRunning();
    }
    
}
