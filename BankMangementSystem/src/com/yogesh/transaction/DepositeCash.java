package com.yogesh.transaction;

import com.yogesh.dbandadmin.GlobalDatabase;

public class DepositeCash {
    
    public DepositeCash(String initialBalance , String depositeAmount , String accountNo)
    {
                int balance = Integer.parseInt(initialBalance);
                int depoAmount  = Integer.parseInt(depositeAmount);
                balance = balance + depoAmount ;
                
                //Value will change in Account Table
                GlobalDatabase.nonSelectQuery("UPDATE account SET balance='"+ balance +"' Where accountno = '"+ accountNo +"'");
                String particulars = "CASH DEPOSITE";
                String withdrawAmount = " ";
                
                new TransactionTracking(accountNo,particulars, withdrawAmount ,String.valueOf(depositeAmount),String.valueOf(balance));
                
    }  
}
