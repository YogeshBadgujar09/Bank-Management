
package com.yogesh.transaction;

import com.yogesh.dbandadmin.GlobalDatabase;
import java.util.Scanner;

import com.yogesh.optimization.AccountAvailableClass;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
       
public class DepositeCash {
    
    DepositeCash()
    {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter Your Account Number :");
        String accountNo = scanner.next();
        
        ResultSet resultSet = new AccountAvailableClass().accountAvailable(accountNo);
       
        if(resultSet != null)
        {
            try {
 
                System.out.println(resultSet.getString(1)+ " " + resultSet.getString(16));

                int balance = Integer.parseInt(resultSet.getString(16));

                System.out.println("Enter Amount to Deposite");
                int depositeAmount = scanner.nextInt();

                System.out.println(depositeAmount);

                balance = balance + depositeAmount ;
                
                //Value will change in Account Table
                GlobalDatabase.nonSelectQuery("UPDATE account SET balance='"+ balance +"' Where accountno = '"+ accountNo +"'");
                String particulars = "DEPOSITE - TO CASH";
                String withdrawAmount = " ";
                
                new TransactionTracking(accountNo,particulars, withdrawAmount ,String.valueOf(depositeAmount),String.valueOf(balance));
            
            } catch (SQLException ex) {
                Logger.getLogger(DepositeCash.class.getName()).log(Level.SEVERE, null, ex);
            } 

        }else{
            System.out.println("Account Not Found ... !!!");
        }
    }
    
    public static void main(String args[])
    {
            new DepositeCash();
    }
    
}
