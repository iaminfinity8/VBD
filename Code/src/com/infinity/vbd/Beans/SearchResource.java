/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infinity.vbd.Beans;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;


public class SearchResource implements Serializable {
private HashMap<String,String> hm1=new HashMap<String,String>(); 

public HashMap<String, String> getHm1() {
    return hm1;
}

public void Generate(){
     // The name of the file to open.
        String fileName = "src/infinity/vbd/Utilities/review2.txt";
        int i=1; // This will reference one line at a time
        String line = null;
        String meaning = null;
        try {

            FileReader fileReader = new FileReader(fileName);             // FileReader reads text files in the default encoding.
            try (BufferedReader bufferedReader = new BufferedReader(fileReader) // Always wrap FileReader in BufferedReader.
            ) {
                while ((line = bufferedReader.readLine()) != null) {
                    meaning=bufferedReader.readLine();
                    hm1.put(line, meaning);//System.out.print(i+"    ");
                    System.out.print(line+" : ");//System.out.print(" : ");
                    System.out.println(meaning); //bufferedReader.readLine();
                    i++;
                }
                // Always close files.
            }
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");    // Or we could just do this : ex.printStackTrace();        
            
        }
    }
}
