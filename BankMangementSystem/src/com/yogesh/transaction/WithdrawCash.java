
package com.yogesh.transaction;

import com.yogesh.dbandadmin.GlobalDatabase;
import javax.swing.JOptionPane;

/**
 *
 * @author Yogesh
 */
public class WithdrawCash {
    
    public Boolean withdrawCashFun(String initialBalance , String withdrawAmount , String accountNo){
           
            int balance = Integer.parseInt(initialBalance);
            int withdraAmount  = Integer.parseInt(withdrawAmount);
           
            
            if(balance > 0 && withdraAmount <= balance ){
                
                balance = balance - withdraAmount ;
                GlobalDatabase.nonSelectQuery("UPDATE account SET balance='"+ balance +"' Where accountno = '"+ accountNo +"'");
                
                String particulars = "CASH WITHDRAW";
                String depositeAmount = " ";

                new TransactionTracking(accountNo,particulars, String.valueOf(withdrawAmount) ,depositeAmount,String.valueOf(balance));
                
                return true ;
            
            }else{
                JOptionPane.showMessageDialog(null, "Your Balance Available in Account :" +  balance + "\n Enter Valid Balance");
            }
             
        return false;
    }    
}
