/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infinity.vbd.DaoInterfaces;

import edu.cmu.sphinx.api.LiveSpeechRecognizer;

/**
 *
 * @author Akash
 */
public interface SpeechListenerInterface {
    
    public LiveSpeechRecognizer CommandRecognizer();
}
