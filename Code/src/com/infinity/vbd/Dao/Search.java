/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infinity.vbd.Dao;

import com.infinity.vbd.Beans.SearchBean;
import java.io.IOException;

/**
 *
 * @author Shubham
 */
public class Search implements com.infinity.vbd.DaoInterfaces.SearchInterface{
    SearchBean sb;

    public Search() throws IOException, ClassNotFoundException {
        this.sb = new SearchBean();
    }
    
    @Override
    public boolean searchMeaning(String word){
        if(sb.getDictionary().containsKey(word))
        {
            return true;
        }
            else
            return false; 
    }

    @Override
    public String getMeaning(String word) {
        return sb.getDictionary().get(word);
    }
    
}
