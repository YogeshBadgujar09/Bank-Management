/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yogesh.transaction;

import com.yogesh.dbandadmin.GlobalDatabase;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author Yogesh
 */
public class TransactionTracking {
    
       public TransactionTracking(String accountNo ,String particulars, String debitAmount, String creditAmount ,String totalBalance ){
        
          Random random = new Random();
            int randomId; 
            
            do{
                randomId = random.nextInt();
            }while(randomId < 1);
          
            String transactionId = "TRAN" + randomId;
            System.out.print(transactionId);
            
            Date date = new Date();
            SimpleDateFormat simpleDateFormat= new SimpleDateFormat("dd-MMM-YYYY");
            String formatedDate = simpleDateFormat.format(date);
               System.out.println(formatedDate);
                //Transaction Tracking
               GlobalDatabase.nonSelectQuery("INSERT INTO transaction VALUES('"+transactionId+"','"+ accountNo +"','"+ particulars +"','"+ debitAmount +"','"+ creditAmount +"','SUCCESSFUL','"+formatedDate+"','"+ totalBalance+"')");
                
        }
    
}
