
package com.yogesh.closeaccount;
import com.yogesh.dbandadmin.GlobalDatabase;

public class CloseAccount {
     
    public CloseAccount(String accountNo)
    {
                        GlobalDatabase.nonSelectQuery("DELETE FROM account WHERE accountno ='" + accountNo + "'");
                        GlobalDatabase.closeConnection();
    }
}
