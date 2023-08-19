package com.castlebell.lingvo.util;

public class StringUtil {
    
    public static boolean isNull(String str) {
        return str == null;
    }

    public static Integer stringToInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static Double stringToDouble(String str) {
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException e) {
            return null;
        }
    }
    
    public static String objectToString(Object obj) {
        if (obj == null) {
            return "";
        } else {
            return obj.toString();
        }
    }
}