/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infinity.vbd;

import com.infinity.vbd.Dao.MainClass;
import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;



public class Main extends Application {
       
    MainClass MC;
  @Override
   public void start(Stage stage) throws Exception {
       MC=new MainClass(stage);
       MC.start(stage);
   }
  
    public static void main(String[] args) throws IOException {
        
        launch(args);
    }
    
}
