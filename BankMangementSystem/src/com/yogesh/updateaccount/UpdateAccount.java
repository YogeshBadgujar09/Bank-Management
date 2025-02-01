
package com.yogesh.updateaccount;

import com.yogesh.dbandadmin.GlobalDatabase;
import com.yogesh.openaccount.OpenAccountModel;

public class UpdateAccount {
    
    public Boolean  UpdateAccount(OpenAccountModel openAccountModel, String accountNumber)
    {   
 
                            GlobalDatabase.nonSelectQuery("UPDATE account SET first_name='" +openAccountModel.getFirstName()+"' WHERE accountno ='" + accountNumber + "'");
                            GlobalDatabase.nonSelectQuery("UPDATE account SET middle_name='" +openAccountModel.getMiddleName()+"' WHERE accountno ='" + accountNumber + "'");
                            GlobalDatabase.nonSelectQuery("UPDATE account SET last_name='" +openAccountModel.getLastName()+"' WHERE accountno ='" + accountNumber + "'");
                            GlobalDatabase.nonSelectQuery("UPDATE account SET dateofbirth='" +openAccountModel.getDateOfBirth()+"' WHERE accountno ='" + accountNumber + "'");
                            GlobalDatabase.nonSelectQuery("UPDATE account SET gender='" +openAccountModel.getGender()+"' WHERE accountno ='" + accountNumber + "'");
                            GlobalDatabase.nonSelectQuery("UPDATE account SET mobileno='" +openAccountModel.getMobileNo()+"' WHERE accountno ='" + accountNumber + "'");
                            GlobalDatabase.nonSelectQuery("UPDATE account SET email='" +openAccountModel.getEmail()+"' WHERE accountno ='" + accountNumber + "'");
                            GlobalDatabase.nonSelectQuery("UPDATE account SET address='" +openAccountModel.getAddress()+"' WHERE accountno ='" + accountNumber + "'");
                            GlobalDatabase.nonSelectQuery("UPDATE account SET city='" +openAccountModel.getCity()+"' WHERE accountno ='" + accountNumber + "'");
                            GlobalDatabase.nonSelectQuery("UPDATE account SET division='" +openAccountModel.getDivision()+"' WHERE accountno ='" + accountNumber + "'");
                            GlobalDatabase.nonSelectQuery("UPDATE account SET district='" +openAccountModel.getDistrict()+"' WHERE accountno ='" + accountNumber + "'");
                            GlobalDatabase.nonSelectQuery("UPDATE account SET pincode='" +openAccountModel.getPinCode()+"' WHERE accountno ='" + accountNumber + "'");
                            GlobalDatabase.nonSelectQuery("UPDATE account SET state='" +openAccountModel.getState()+"' WHERE accountno ='" + accountNumber + "'");
                                    
        GlobalDatabase.closeConnection();
        
        return true;
    }
}
