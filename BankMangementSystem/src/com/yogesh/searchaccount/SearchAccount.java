/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yogesh.searchaccount;

import com.yogesh.dbandadmin.GlobalDatabase;
import com.yogesh.optimization.AccountAvailableClass;
import java.sql.ResultSet;


/**
 *
 * @author Yogesh
 */
public class SearchAccount {
    
    public ResultSet searchAccount(String accountNo)
    {
            ResultSet resultSet = new AccountAvailableClass().accountAvailable(accountNo);
            
            if(resultSet != null){
              
                    return resultSet ;      
            }        

        GlobalDatabase.closeConnection();
        return null;
    }

}
