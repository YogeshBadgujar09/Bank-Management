/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yogesh.optimization;

import com.toedter.calendar.JDateChooser;
import com.yogesh.openaccount.OpenAccountModel;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Yogesh
 */
public class PersonalInformationClass {
    
   
    public boolean personalInformation( OpenAccountModel openAccountModel,String info[] , JTextField txtInfo[] ,
                                        JDateChooser dateDOB , JLabel lblInfo[]  )
    {
        boolean[] validate = new boolean[13];
    //    System.out.println("fname :");
        validate[0] = openAccountModel.setFirstName(info[0], txtInfo[0] , lblInfo[0]);
    //    System.out.println("mname :");
        validate[1] = openAccountModel.setMiddleName(info[1], txtInfo[1] , lblInfo[1] );
     //   System.out.println("lname :");
        validate[2] = openAccountModel.setLastName(info[2], txtInfo[2] , lblInfo[2] );
    //    System.out.println("dob :");
        validate[3] = openAccountModel.setDateOfBirth(info[3], dateDOB, lblInfo[3]);
    //    System.out.println("gender :");
        validate[4] = openAccountModel.setGender(info[4], lblInfo[4]);
     //   System.out.println("mob :");
        validate[5] = openAccountModel.setMobileNo(info[5], txtInfo[3], lblInfo[5]);
    //    System.out.println("email :");
        validate[6] = openAccountModel.setEmail(info[6], txtInfo[4],lblInfo[6]);
    //    System.out.println("address :");
        validate[7] = openAccountModel.setAddress(info[7],txtInfo[5],lblInfo[7]);
    //    System.out.println("city :");
        validate[8] = openAccountModel.setCity(info[8], txtInfo[6], lblInfo[8] );
    //    System.out.println("division:");
        validate[9] = openAccountModel.setDivision(info[9], txtInfo[7], lblInfo[9]);
    //    System.out.println("district :");
        validate[10] = openAccountModel.setDistrict(info[10],txtInfo[8], lblInfo[10]);
     //   System.out.println("pincode :");
        validate[11] = openAccountModel.setPinCode(info[11], txtInfo[9],lblInfo[11]);
     //   System.out.println("state :");
        validate[12] = openAccountModel.setState(info[12], txtInfo[10], lblInfo[12] );    
        
        int validateVariable = 0 ;
       for(int i=0; i<validate.length; i++)
       {
           if(validate[i] != false)
           {
               validateVariable++;
           }
       }
       
        return validateVariable == 13;
    }
}
