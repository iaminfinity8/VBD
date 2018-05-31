/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infinity.vbd.DaoInterfaces;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.SourceDataLine;


/**
 *
 * @author Akash
 */
public interface AudioPlayerInterface_1 {
    public void setAudio(AudioInputStream audio);
    public void cancel();
    public SourceDataLine getLine();
    public float getGainValue();
    public void setGain(float fGain);
    
    
}
