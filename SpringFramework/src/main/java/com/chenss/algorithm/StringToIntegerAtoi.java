package com.chenss.algorithm;

import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;

import javax.sound.midi.Soundbank;

public class StringToIntegerAtoi {
    public int myAtoi(String str) {
        str = str.trim();
        int blSub = 0;
        String stt = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '+' || str.charAt(i) == '-') {
                if (stt.length()>0) {
                    break;
                }
                if (blSub!=0) {
                    break;
                }
                blSub = str.charAt(i) == '-'?-1 :1;
            } else if (str.charAt(i) <= '9' && str.charAt(i) >= '0') {
                if (str.charAt(i) == 48 && stt.length() == 0) {
                    blSub=blSub==0?1:blSub;
                    continue;
                }
                stt += str.charAt(i);
            } else {
                break;
            }
        }
        if (stt.length() == 0) {
            return 0;
        } else if (blSub==-1 && stt.length() > 10) {
            return Integer.MIN_VALUE;
        } else if (stt.length() > 10) {
            return Integer.MAX_VALUE;
        }
        try {
            int intR = Integer.parseInt(blSub==-1 ? "-" + stt : stt);
            return intR;
        } catch (Exception ex) {
            return blSub==-1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
    }

    public static void main(String[] args) {
        StringToIntegerAtoi atoi = new StringToIntegerAtoi();
        System.out.println(atoi.myAtoi("123-"));
    }
}
