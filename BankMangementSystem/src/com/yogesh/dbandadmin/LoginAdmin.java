
package com.yogesh.dbandadmin;
 
import java.sql.ResultSet;
import java.sql.SQLException;
import com.yogesh.frontend.AdminLogin;

public class LoginAdmin {
    
    
    public boolean LoginAdmin(String userName , String password ){
    
        AdminLogin adminLogin = new AdminLogin();
        
        GlobalDatabase.createConnection();
    
        ResultSet resultSetUsernameAlreadyAvl = GlobalDatabase.selectQuery("SELECT * FROM admin WHERE username = '"+ userName +"'");

        try {
            if(resultSetUsernameAlreadyAvl.next()) {

                if(resultSetUsernameAlreadyAvl.getString(1).equals(userName) && resultSetUsernameAlreadyAvl.getString(2).equals(password))
                {
                    System.out.println("Welcome Back .... !!! ");
                    //   new Dashboard().setVisible(true);
                } else if(resultSetUsernameAlreadyAvl.getString(1).equals(userName)){
                    //System.out.println("Please enter valid Password ... !!!");
//                    adminLogin.lblInvalidUsername.setVisible(false);
//                    adminLogin.psPassword.requestFocus();
//                    adminLogin.lblWrongPassword.setVisible(true);
                      return true ;
                }
            }
            else {
                //System.out.println("Please enter valid Username OR Password .... !!! ");
//                adminLogin.lblInvalidUsername.setVisible(true);
//                adminLogin.txtUsername.requestFocus();
                  return false;
            }
        } catch (SQLException ex) {
            //                    System.out.println("Please enter valid Username OR Password .... !!! ");
//            adminLogin.lblInvalidUsername.setVisible(true);
//            adminLogin.txtUsername.requestFocus();
            
            throw new RuntimeException(ex);
           
        }

        GlobalDatabase.closeConnection();
        return false ;
    }
}
