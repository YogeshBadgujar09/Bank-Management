
package com.yogesh.imagecode;
import com.yogesh.dbandadmin.GlobalDatabase;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ImageSave {
    
    public boolean ImageSaveFun(String accountNo, String customerImagePath, String customerSignPath){
            
       GlobalDatabase.createConnection();
       
//        accountNo = "00001234567890";
//        customerImagePath = "C:\\Users\\Yogesh\\Desktop\\depositeAndwithdraw.png";
//        customerSignPath  = "C:\\Users\\Yogesh\\Desktop\\Screenshot 2025-02-21 214029.jpg";
       
       //            FileInputStream imageFileInputStream = new FileInputStream(customerImagePath);
//            FileInputStream signFileInputStream = new FileInputStream(customerSignPath);
//
       
        
        try {
            
            FileInputStream[] file = new FileInputStream[2]; 
            
            file[0] = new FileInputStream(customerImagePath);
            file[1] = new FileInputStream(customerSignPath);
            
            
            byte[] customerImageConvert = new byte[file[0].available()]; 
            byte[] customerSignConvert = new byte[file[1].available()]; 
            
            GlobalDatabase.nonSelectQueryForImage(accountNo, customerImageConvert, customerSignConvert);
            
            return true;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ImageSave.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ImageSave.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
       GlobalDatabase.closeConnection();
       return false;
    }
    
    
//    public static void main(String args[])
//    {
//           new ImageSave();
//    }
    
}
