/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yogesh.optimization;

import com.yogesh.closeaccount.CloseAccount;
import com.yogesh.dbandadmin.GlobalDatabase;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Yogesh
 */
public class AccountAvailableClass {

    public ResultSet accountAvailable(String accountNo) {
        
        GlobalDatabase.createConnection();
             
         ResultSet resultSet = GlobalDatabase.selectQuery("SELECT * FROM account WHERE accountno = '"+ accountNo +"'");
            
        try {
            if(resultSet.next()){
                return resultSet;     
            }
        } catch (SQLException ex) {
                Logger.getLogger(CloseAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        return null; 
    }  
}
