
package com.yogesh.transaction;

import com.yogesh.dbandadmin.GlobalDatabase;
import javax.swing.JOptionPane;

public class TransferMoney {
    
    public TransferMoney(String accountNo[], String balance[], String transferAmount)
    {
        
        final int senderAccountNoINDEX = 0;
        final int receiverAccountNoINDEX = 1;
        
        final int senderBalanceINDEX = 0;
        final int receiverBalanceINDEX = 1;
        
        
        int senderBalance = Integer.parseInt(balance[senderBalanceINDEX]);
        int recieverBalance = Integer.parseInt(balance[receiverBalanceINDEX]);
        int transferAmountINT = Integer.parseInt(transferAmount);
        
        String senderAccountNumber = accountNo[senderAccountNoINDEX];
        String recieverAccountNo = accountNo[receiverAccountNoINDEX];
             
                final int MINIMUM_BALANCE = 0 ;
                final int MAXIMUM_BALANCE = senderBalance;
//                
                if(senderBalance > MINIMUM_BALANCE && transferAmountINT < MAXIMUM_BALANCE )
                {
//                    flag = true ;
                    System.out.println("You enter Valid Amount .... !!!");
                    
                    senderBalance = senderBalance - transferAmountINT ;
                    GlobalDatabase.nonSelectQuery("UPDATE account SET balance='"+ senderBalance +"' Where accountno = '"+ senderAccountNumber +"'");
                    String particulars = "TO " + recieverAccountNo;
                    String credit = " ";
                    new TransactionTracking(senderAccountNumber, particulars, String.valueOf(transferAmount), credit , String.valueOf(senderBalance));
                    
                    
                    // Recieve Money ....
             
                    recieverBalance = recieverBalance + transferAmountINT ;
                    GlobalDatabase.nonSelectQuery("UPDATE account SET balance='"+ recieverBalance +"' Where accountno = '"+ recieverAccountNo +"'");
                    particulars = "FROM " + String.valueOf(senderAccountNumber);
                    String debit = " ";
                    new TransactionTracking(recieverAccountNo, particulars,debit, String.valueOf(transferAmount),String.valueOf(recieverBalance));
                    
                    JOptionPane.showMessageDialog(null, "Money Tranfer Successfully ... !!!");
                    System.out.println("Tranfer Successfull ... !!!");
                    
                    
                }else{
                   JOptionPane.showMessageDialog(null, "Money Not Transfer ... !!! \nSender Balance :" + senderBalance + "\nTransfer Amount :" + transferAmountINT);
                }

    }
}
