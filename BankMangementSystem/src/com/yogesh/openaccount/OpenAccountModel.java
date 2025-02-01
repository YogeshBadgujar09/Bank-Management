package com.yogesh.openaccount;

import com.toedter.calendar.JDateChooser;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
/**
 *
 * @author Yogesh
 */
public class OpenAccountModel {
    
   private String firstName ;
   private String middleName ;
   private String lastName ;
   private String dateOfBirth ;
   private String gender;
   private String mobileNo;
   private String email;
   
   private String address ;
   private String city ;
   private String division;
   private String district;
   private String pinCode;
   private String state;
   
   private String aadharNumber;
   private String accountNumber;
   private String balance;

   Pattern pattern;
   Matcher matcher ;
   boolean flag ;
   
   
    public String getFirstName() {
        return firstName;
    }

    
    public boolean setFirstName(String firstName, JTextField txtFirstName , JLabel lblFirstNameReq ) {
       
           flag  = InputDataValidation(firstName, txtFirstName);
           
           if(!flag){
              lblFirstNameReq.setVisible(true);
              return false ;
           }
            if(flag){
             this.firstName = firstName ;
             lblFirstNameReq.setVisible(false);
             }
            return true ;
    }

    public String getMiddleName() {
        return middleName;
    }

    public boolean setMiddleName(String middleName, JTextField txtMiddleName , JLabel lblMiddleNameReq) {
       flag  = InputDataValidation(middleName, txtMiddleName );
       
       if(!flag){
            lblMiddleNameReq.setVisible(true);
            return false;
       }else{
           this.middleName = middleName ;
           lblMiddleNameReq.setVisible(false);
       }
       return true;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean setLastName(String lastName, JTextField txtLastName, JLabel lblLastNameReq) {
        
        
        flag = InputDataValidation(lastName, txtLastName);
        if(!flag){
           lblLastNameReq.setVisible(true);
           return false;
        }else{
            lblLastNameReq.setVisible(false);
            this.lastName = lastName ;
        }
       return true; 
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public boolean setDateOfBirth(String dateOfBirth , JDateChooser dateDOB, JLabel lblDateReq) {
       
        if(dateOfBirth == null)
        {
            dateDOB.requestFocus();
            lblDateReq.setVisible(true);
            return false;
        }
        else{
            this.dateOfBirth = dateOfBirth;  
            lblDateReq.setVisible(false);
        }
       return true ;
    }
    
       public String getGender() {
        return gender;
    }

    public boolean setGender(String gender, JLabel lblGenderReq) {
        
        if(gender == null){
            lblGenderReq.setVisible(true);
            return false;
        }
        else{
         this.gender = gender;
         lblGenderReq.setVisible(false);
        }
        return true;
    }

    

    public String getMobileNo() {
        return mobileNo;
    }

    public boolean setMobileNo(String mobileNo, JTextField txtMobile, JLabel lblMobileReq) {
        
        pattern = Pattern.compile("[0-9]{10}");
        matcher = pattern.matcher(mobileNo)  ;

        if(matcher.matches())
        {  
             this.mobileNo = mobileNo;
             lblMobileReq.setVisible(false);
             return true;
        }
        else{
         //   System.out.println("please enter valid Mobile Number [Enter 10 Digits] ");
            lblMobileReq.setVisible(true);
           // JOptionPane.showMessageDialog(null,"please enter valid Mobile Number [Enter 10 Digits] " );
            txtMobile.requestFocus();
            txtMobile.setText("");        
        }

        return false;
    }

    public String getEmail() {
        return email;
    }

    public boolean setEmail(String email ,JTextField txtEmail , JLabel lblEmailReq ) {
        
        pattern =  Pattern.compile( "^[a-z0-9_]+@" +  "[a-zA-Z0-9-]+" + "\\." + "[a-z" + "]{2,3}$");
        matcher =  pattern.matcher(email);

        if(matcher.matches())
        {
           this.email = email;
           lblEmailReq.setVisible(false);
           return true;
        }
        else{
          //  System.out.println("please enter valid email .[use lowercase / use Valid Symbols ] ");
            //JOptionPane.showMessageDialog(null,"please enter valid email .[use lowercase / use Valid Symbols ]");  
            lblEmailReq.setVisible(true);
        }
        return false;
    }

    public String getAadharNumber() {
        return aadharNumber;
    }

    public boolean setAadharNumber(String aadharNumber, JTextField txtAadhar) {
        
        pattern = Pattern.compile("[0-9]{12}");
        matcher = pattern.matcher(aadharNumber)  ;

        if(matcher.matches())
        {
           this.aadharNumber = aadharNumber; 
           return true;
        }
        else{
          //  System.out.println("please enter valid Aadhar Number [Enter 12 Digits] ");
            
            txtAadhar.requestFocus();
            txtAadhar.setText("");
            return false;
        }
        
    }

    public String getAddress() {
        return address;
    }

    public boolean setAddress(String address, JTextField txtAddress, JLabel lblAddressReq) {
        flag = InputDataValidation(address, txtAddress);
        
        if(!flag)
        {
            lblAddressReq.setVisible(true);
            return false;
          //  JOptionPane.showMessageDialog(null, "Please enter valid address");
        }
        else{
            lblAddressReq.setVisible(false);
            this.address = address;
        }
        return true;
    }

    public String getCity() {
        return city;
    }

    public boolean setCity(String city, JTextField txtCity, JLabel lblCityReq ) {
        
        flag = InputDataValidation(city,txtCity);
        
        if(!flag){
           // JOptionPane.showMessageDialog(null, "Please enter valid city");
           lblCityReq.setVisible(true);
           return false;
        }else{
             lblCityReq.setVisible(false);
            this.city = city ;
        }
        return true;
    }
    
    
    public String getDivision() {
        return division;
    }

    public boolean setDivision(String division, JTextField txtDivision, JLabel lblDivisionReq) {
        flag = InputDataValidation(division,txtDivision);
        
        if(!flag){
          //  JOptionPane.showMessageDialog(null, "Please enter divion");
            lblDivisionReq.setVisible(true);
            return false;
            
        }else{
            lblDivisionReq.setVisible(false);
            this.division = division  ;
        }
        
        return true;
    }

    public String getDistrict() {
        return district;
    }

    public boolean setDistrict(String district, JTextField txtDistrict, JLabel lblDistrictReq ) {
        flag = InputDataValidation(district,txtDistrict);
        
        if(!flag){
         //   JOptionPane.showMessageDialog(null, "Please enter District");
         lblDistrictReq.setVisible(true);
         return false;
             
        }else{
            lblDistrictReq.setVisible(false);
            this.district = district ;
        }
        return true;
    }

    public String getPinCode() {
        return pinCode;
    }

    public boolean setPinCode(String pinCode, JTextField txtPinCode, JLabel lblPinCodeReq) {
        
        pattern = Pattern.compile("[0-9]{6}");
        matcher = pattern.matcher(pinCode)  ;

        if(matcher.matches())
        {
            lblPinCodeReq.setVisible(false);
            this.pinCode = pinCode;
            return true;
        }
        else{
//            System.out.println("please enter valid pin code [Enter 6 Digits] ");
//            JOptionPane.showMessageDialog(null, "please enter valid pin code [Enter 6 Digits] " );
            lblPinCodeReq.setVisible(true);
            txtPinCode.requestFocus();
            txtPinCode.setText("");  
        }
        return false;       
    }    

    public String getState() {
        return state;
    }

    public boolean setState(String state, JTextField txtState, JLabel lblStateReq) {
        
        flag = InputDataValidation(state, txtState);
        
        if(!flag){
           // JOptionPane.showMessageDialog(null, "Please enter state");
           lblStateReq.setVisible(true);
           return false;
        }else{
            lblStateReq.setVisible(false);
            this.state = state ;
        }
        return true;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBalance() {
        return balance;
    }

    public boolean setBalance(String balance, JTextField txtBalance) {
        
        pattern =  Pattern.compile("^[0-9]{4,}$");
        matcher =  pattern.matcher(balance);
            
            if(matcher.matches())
            {
                this.balance = balance;
                return true;
            }else{
                JOptionPane.showMessageDialog(null,"Deposite MINIMUM 1000rs.");
               // System.out.println("Enter Minimun 1000 Rs.");
                txtBalance.requestFocus();
                txtBalance.setText("");
            }
          return false;
    }
    
    
    public boolean InputDataValidation(String data,JTextField txtObject)
    {
        pattern = Pattern.compile("[A-Za-z32]{1,}");
        matcher = pattern.matcher(data);
        
            data = txtObject.getText();
            matcher = pattern.matcher(data);
        
       if(matcher.matches()){
           return true;
       }else{
           txtObject.requestFocus();
           txtObject.setText("");    
       }
       return false;
    }

    @Override
    public String toString() {
        return "OpenAccountModel{" + "firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth + ", mobileNo=" + mobileNo + ", email=" + email + ", aadharNumber=" + aadharNumber + ", address=" + address + ", city=" + city + ", state=" + state + ", accountNumber=" + accountNumber + ", balance=" + balance + '}';
    }
 
    
}
