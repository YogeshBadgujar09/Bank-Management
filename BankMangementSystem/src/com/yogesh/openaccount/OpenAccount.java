
package com.yogesh.openaccount;

import com.yogesh.dbandadmin.GlobalDatabase;
import com.yogesh.optimization.AccountAvailableClass;
import java.util.Random;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



/**
 *
 * @author Yogesh
 */
public class OpenAccount {
    
    
   public boolean aadharCheckAlreadyAvailable(OpenAccountModel openAccountModel, String aadharNo, JTextField txtAadhar , JTextField txtAccountNo )
    { 
        
       
        GlobalDatabase.createConnection();
   
        boolean flag = false;
      
           
          //  System.out.println("aadhar :");
          //  openAccountModel.setAadharNumber(scanner.next(),scanner);
           boolean validAadharNo = openAccountModel.setAadharNumber(aadharNo,txtAadhar);
           String aadhar = openAccountModel.getAadharNumber();
            
            if(validAadharNo){
                
                   ResultSet resultSetAadhar = GlobalDatabase.selectQuery("SELECT * FROM account WHERE aadhar = '"+ aadhar +"'");
            
                try {
                    
                    if(resultSetAadhar.next())
                    {
                        //System.out.println("Aadhar :" + resultSetAadhar.getString(11));
                       // JOptionPane.showMessageDialog(javax.swing.JFrame.pnlOpenAccount(), "Account Already Available on This Aadhar Number ... !!!");
                        JOptionPane.showMessageDialog(null, "Account Already Available with this Aadhar Number  ...... !!!"); 
                        System.out.println("Account Already Available with this Aadhar Number  ...... !!!");
                        System.out.println("Another try  ... !!!");                   
                        return false ;
                    } 
                } catch (SQLException ex) {
                    flag = false;
                    Logger.getLogger(OpenAccount.class.getName()).log(Level.SEVERE, null, ex);
                }    
           
                if( flag == false)
                {
                    System.out.println("Aadhar Number Use to Create Account ... !!!!!");
                }
        
    

                if(flag == false){


                    System.out.println("accountNumber Generating ......... !!!") ;

                 //   boolean accountNomatch ;

                    System.out.println("Enter Account Number :");
                    String accountNo = generateAccountNumber() ;

                        ResultSet resultSetAccount = new AccountAvailableClass().accountAvailable(accountNo);

                        if(resultSetAccount != null)
                        {

                            System.out.println("Accout Already Available ...... !!!");
                            System.out.println("Another try to generate Account No ... !!!");
                         //   accountNomatch = true ;

                            return false ;
                        }
                        else{
                            openAccountModel.setAccountNumber(accountNo);
                            txtAccountNo.setText(accountNo);
                         //   accountNomatch = false ;
                        }               
                }

            
        }else{
            JOptionPane.showMessageDialog(null, "Enter Valid Aadhar Number .... !!!!");
            return false;
        }
            
         
        
        GlobalDatabase.closeConnection();
        return true ;
    }  
    
    public String generateAccountNumber() {

        Random random = new Random();
        String accountNoStrForm  ;
        while(true) {
            int accountNumber = random.nextInt();
             accountNoStrForm = String.valueOf(accountNumber);

            if(accountNumber > 1 && accountNoStrForm.length() == 10) {
                return "0000"+accountNoStrForm;
            }
        }
     }
    
//    public boolean initialBalance(OpenAccountModel openAccountModel ,String balance , JTextField txtBalance)
//    {
//          boolean validation = openAccountModel.setBalance(balance, txtBalance); 
//          return validation;
//    }
}
