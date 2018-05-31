/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infinity.vbd.Dao;

import com.infinity.vbd.Beans.TextToSpeechBean;
import java.io.IOException;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import marytts.LocalMaryInterface;
import marytts.exceptions.MaryConfigurationException;
import marytts.exceptions.SynthesisException;
import marytts.modules.synthesis.Voice;

/**
 *
 * @author Akash
 */
public class TextToSpeech {
    TextToSpeechBean TTSB=new TextToSpeechBean();
    public TextToSpeech() {
		try {
			TTSB.setMarytts(new LocalMaryInterface()) ;

		} catch (MaryConfigurationException ex) {
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
		}
	}

	
    public Collection<Voice> getAvailableVoices() {
            return Voice.getAvailableVoices();
    }


    public void setVoice(String voice) {
            (TTSB.getMarytts()).setVoice(voice);
    }

    public void speak(String text, float gainValue, boolean daemon, boolean join) throws InterruptedException, SynthesisException {

            // Stop the previous player
            stopSpeaking();

            try (AudioInputStream audio = (TTSB.getMarytts()).generateAudio(text)) {

                    // Player is a thread(threads can only run one time) so it can be
                    // used has to be initiated every time
                    TTSB.setTts(new AudioPlayer());
                    (TTSB.getTts()).setAudio(audio);
                    (TTSB.getTts()).setGain(gainValue);
                    (TTSB.getTts()).setDaemon(daemon);
                    (TTSB.getTts()).start();
                    if (join)
                            (TTSB.getTts()).join();

            } catch (IOException ex) {
                    Logger.getLogger(getClass().getName()).log(Level.WARNING, "IO Exception", ex);
            }
    }

    /**
     * Stop the MaryTTS from Speaking
     */
    public void stopSpeaking() {
            // Stop the previous player
            if ((TTSB.getTts()) != null)
                    TTSB.getTts().cancel();
    }

    
}
