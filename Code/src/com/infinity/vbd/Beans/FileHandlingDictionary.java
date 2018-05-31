/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infinity.vbd.Beans;
import java.io.*;

public class FileHandlingDictionary {
   
    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
       
       /* // The name of the file to open.
        String fileName = "temp.txt";
        int i=1;
        // This will reference one line at a time
        String line = null;
        String meaning = null;
        HashMap<String,String> hm=new HashMap<String,String>();
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                               
                meaning=bufferedReader.readLine();
                hm.put(line, meaning);
                System.out.print(i+"    ");
                System.out.print(line);
                System.out.print(" : "); 
                System.out.println(meaning); 
                bufferedReader.readLine();
                i++;
                
            }   

            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
   */
       
       
       SearchResource sr=new SearchResource();
       sr.Generate();
        FileOutputStream fout;  
        fout = new FileOutputStream("src/com/infinity/vbd/Utilities/DictionaryContent.dat");
        System.out.println("File Created");
        try (ObjectOutputStream out = new ObjectOutputStream(fout)) {
            out.writeObject(sr);
            out.flush();
        }

            
       
    }
    
}
