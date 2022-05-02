package com.test;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     System.out.print("Input your OTP key: ");
     String key = sc.nextLine();
     sc.close();
  
     OTPSecurity os = new OTPSecurity();
     os.CheckOTP(null, key);
  }
  
}
