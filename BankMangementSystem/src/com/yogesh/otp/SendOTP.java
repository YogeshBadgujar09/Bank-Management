
package com.yogesh.otp;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import java.util.Scanner;
import java.util.Random;

public class SendOTP {
    
    public String SendOTPFunctionality(String msg)
    {
        String accountSID = "AC2b8e564c86d1ca13f30ec80d4c065306";
        // Your Auth Token from (link unavailable)
        String authToken = "a88e0e6323ec8b25d645d1551a3246da";
        Twilio.init(accountSID, authToken);

        // Generate OTP
        String otp = generateOtp();

        // Send OTP
        Message message = Message.creator(
                        new PhoneNumber("+919770300812"), // To number
                        new PhoneNumber("+12765313913"), // From number
                        msg + otp)
                .create();

        System.out.println("OTP sent successfully!");
        
        return otp;
    }

    private static String generateOtp() {
        // 6-digit random OTP
        Random random = new Random();
        StringBuilder otp = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            otp.append(random.nextInt(10));
        }
        return otp.toString();
    }
}
