
package com.yogesh.transaction;

import com.yogesh.dbandadmin.GlobalDatabase;
import com.yogesh.optimization.AccountAvailableClass;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yogesh
 */
public class WithdrawCash {
    
    WithdrawCash()
    {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter Your Account Number :");
        String accountNo = scanner.next();
        
        ResultSet resultSet = new AccountAvailableClass().accountAvailable(accountNo);
       
        try {
 
            System.out.println(resultSet.getString(1)+ " " + resultSet.getString(16));
            
            int balance = Integer.parseInt(resultSet.getString(16));
            
            System.out.println("Enter Amount to withdraw :");
            int withdrawAmount = scanner.nextInt();
            
            System.out.println(withdrawAmount);
            
            balance = balance - withdrawAmount ;
            
            GlobalDatabase.nonSelectQuery("UPDATE account SET balance='"+ balance +"' Where accountno = '"+ accountNo +"'");
                String particulars = "WITHDRAW - TO CASH";
                String depositeAmount = " ";
          new TransactionTracking(accountNo,particulars, String.valueOf(withdrawAmount) ,depositeAmount,String.valueOf(balance));
            
        } catch (SQLException ex) {
            Logger.getLogger(DepositeCash.class.getName()).log(Level.SEVERE, null, ex);
        }    

    }
    
    public static void main(String args[])
    {
            new WithdrawCash();
    }
    
}
