/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infinity.vbd.Beans;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Akash
 */
public class VoiceResource{
    private String currentVoice;

    public VoiceResource() throws FileNotFoundException, IOException {
        FileReader fr=new FileReader("src/com/infinity/vbd/Utilities/VoiceResource.txt");
        BufferedReader br=new BufferedReader(fr);
        currentVoice=br.readLine();
        br.close();
        fr.close();
    }

    public String getCurrentVoice() {
        FileReader fr = null;
        try {
            fr = new FileReader("src/com/infinity/vbd/Utilities/VoiceResource.txt");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(VoiceResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedReader br=new BufferedReader(fr);
        try {
            currentVoice=br.readLine();
        } catch (IOException ex) {
            Logger.getLogger(VoiceResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return currentVoice;
    }

    public void setCurrentVoice(String currentVoice) throws IOException {
        File f=new File("src/com/infinity/vbd/Utilities/VoiceResource.txt");
        if(f.exists()){
            System.out.println( f.delete());
        }     
        
        try (FileWriter fw = new FileWriter("src/com/infinity/vbd/Utilities/VoiceResource.txt"); 
               BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(currentVoice);
        }
        
                
    }
    
}
