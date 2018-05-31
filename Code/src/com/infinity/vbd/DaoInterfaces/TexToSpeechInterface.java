/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infinity.vbd.DaoInterfaces;

import java.util.Collection;
import marytts.modules.synthesis.Voice;

/**
 *
 * @author Akash
 */
public interface TexToSpeechInterface {
    	public Collection<Voice> getAvailableVoices() ;
        public void setVoice(String voice);
        public void speak(String text, float gainValue, boolean daemon, boolean join);
        public void stopSpeaking();
    
}
