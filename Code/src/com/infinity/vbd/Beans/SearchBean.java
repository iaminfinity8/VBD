/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infinity.vbd.Beans;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Shubham
 */
public class SearchBean {
    private HashMap<String,String> dictionary;
    private static String foundWord;
    private static String foundMeaning;
    public SearchBean() throws IOException, ClassNotFoundException {
        foundWord=null;
        foundMeaning=null;
                    ObjectInputStream in=null;
                    SearchResource s=null;
        try {
            dictionary=new HashMap<>();
           
            in = new ObjectInputStream(new FileInputStream("DictionaryContent.dat"));
            s=(SearchResource)in.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SearchBean.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                Logger.getLogger(SearchBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        dictionary=s.getHm1();
    }

    public HashMap<String, String> getDictionary() {
        return dictionary;
    }

    public static String getFoundWord() {
        return foundWord;
    }

    public static void setFoundWord(String foundWord) {
        SearchBean.foundWord = foundWord;
    }

    public static String getFoundMeaning() {
        return foundMeaning;
    }

    public static void setFoundMeaning(String foundMeaning) {
        SearchBean.foundMeaning = foundMeaning;
    }
    
}
