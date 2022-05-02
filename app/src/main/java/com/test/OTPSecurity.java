package com.test;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class OTPSecurity {
    // input, key
    public boolean CheckOTP(String str, String str2) {
        int i = 5;
        while (true) {
            int i2 = i - 1;
            if (i <= -1) {
                return false;
            }
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(str2));
            stringBuilder.append(GetDateString(i2));
            //if (str.equalsIgnoreCase(Integer.toString(MakeHashCode(stringBuilder.toString())))) {
            //    return true;
            //}
            
            String otp = Integer.toString(MakeHashCode(stringBuilder.toString()));
            System.out.println("OTP: " + otp);
            
            i = i2;
        }
    }

    private String GetDateString(int i) {
        Calendar instance = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        instance.add(12, i * -1);
        String str = "00";
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(new DecimalFormat(str).format((long) (instance.get(1) - 2000))));
        stringBuilder.append(new DecimalFormat(str).format((long) (instance.get(2) + 1)));
        StringBuilder stringBuilder2 = new StringBuilder(String.valueOf(stringBuilder.toString()));
        stringBuilder2.append(new DecimalFormat(str).format((long) instance.get(12)));
        StringBuilder stringBuilder3 = new StringBuilder(String.valueOf(stringBuilder2.toString()));
        stringBuilder3.append(new DecimalFormat(str).format((long) instance.get(5)));
        stringBuilder3 = new StringBuilder(String.valueOf(stringBuilder3.toString()));
        stringBuilder3.append(new DecimalFormat(str).format((long) instance.get(11)));
        return stringBuilder3.toString();
    }

    private int MakeHashCode(String str) {
        int i = 0;
        int i2 = 0;
        while (i < str.length()) {
            i2 = str.charAt(i) + ((i2 << 5) + i2);
            i++;
        }
        return i2 < 0 ? i2 * -1 : i2;
    }
}
