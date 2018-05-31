/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infinity.vbd.Beans;

import com.infinity.vbd.Dao.AudioPlayer;
import marytts.MaryInterface;

/**
 *
 * @author Akash
 */
public class TextToSpeechBean {
        
        private AudioPlayer tts;

    public AudioPlayer getTts() {
        return tts;
    }

    public void setTts(AudioPlayer tts) {
        this.tts = tts;
    }

    public MaryInterface getMarytts() {
        return marytts;
    }

    public void setMarytts(MaryInterface marytts) {
        this.marytts = marytts;
    }
	private MaryInterface	marytts;
    
}
