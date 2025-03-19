/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yogesh.imagecode;

import com.yogesh.dbandadmin.GlobalDatabase;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
/**
 *
 * @author Yogesh
 */
public class ImageRetrive {
    
    ImageRetrive (JLabel label) throws IOException
    {
        GlobalDatabase.createConnection();
            
        ResultSet resultSet = GlobalDatabase.selectQueryForImage("00001234567890");
            
        try {
            
            if(resultSet.next())
            {
                    System.out.println("Account No : " + resultSet.getString(1));
                   
//                    InputStream is = resultSet.getBinaryStream("CUSTOMER_IMAGE");
//                    if (is != null) {
//                        
//                        BufferedImage image = ImageIO.read(is);
//                        
//                        if (image != null) {
//                           label.setIcon(new ImageIcon(image));
//                        } else {
//                      
//                            label.setText("Image not found");
//                        }
//                    }

                
                byte[] getimage = resultSet.getBytes("CUSTOMER_IMAGE");
                ImageIcon putImage = new ImageIcon(getimage);
                Image im = putImage.getImage();
                Image myimage = im.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon i = new ImageIcon(myimage);
                label.setIcon(i);

            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ImageRetrive.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
        GlobalDatabase.closeConnection();

    }
 
}
