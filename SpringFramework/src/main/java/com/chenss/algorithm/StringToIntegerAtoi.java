package com.chenss.algorithm;


public class StringToIntegerAtoi {
    public int myAtoi(String str) {
        int space = 32, add = 43, sub = 45, type = 0;
        boolean blSub = false;
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            int charInt = str.charAt(i);
            if (charInt == space && type==0) {
                continue;
            }else if (charInt==add && type == 0) {
                type=1;
            } else if (charInt==sub && type == 0) {
                type=1;
                blSub=true;
            } else if (charInt<=57 && charInt>=48) {
                type = 2;
                if (charInt==48&& buffer.length()==0) {
                    continue;
                }
                buffer.append(str.charAt(i));
            } else {
                break;
            }
        }
        String result = buffer.toString();
        if (result.length() == 0) {
            return 0;
        } else if (blSub && result.length()>10) {
            return Integer.MIN_VALUE;
        } else if (buffer.length()>10) {
            return Integer.MAX_VALUE;
        }
        try {
            int intR = Integer.parseInt(blSub?"-"+result:result);
            return intR;
        } catch (Exception ex) {
            if (blSub) {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }
    }

    public static void main(String[] args) {
        StringToIntegerAtoi atoi = new StringToIntegerAtoi();
        System.out.println(atoi.myAtoi("123-"));
    }
}
