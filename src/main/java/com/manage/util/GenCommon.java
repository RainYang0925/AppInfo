package com.manage.util;

public class GenCommon {
    
    private static boolean isNeedConvert(char para) {
        return ((para & (0x00FF)) != para);
    }
    
    public static String GBK2Unicode(String str) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char chr1 = str.charAt(i);
 
            if (!isNeedConvert(chr1)) {
                result.append(chr1);
                continue;
            }
 
            result.append("\\u" + Integer.toHexString(chr1));
        }
 
        return result.toString();
    }
    
}
