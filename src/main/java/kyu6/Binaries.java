package kyu6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Behzod on 28, December, 2019
 */
public class Binaries {
    public static void main(String[] args) {
        System.out.println(code("62"));
        System.out.println(code("55337700"));
        System.out.println(code("1119441933000055"));
        System.out.println(code("69"));
        System.out.println(code("86"));
        System.out.println("//////////////////////");
        System.out.println(decode("10001111"));
        System.out.println(decode("001100001100001100001110001110001110011101110111001110001110001110001111001111001111001100001100001100"));
        System.out.println(decode("01110111110001100100011000000110000011110011110111011100110000110001100110"));
        System.out.println(decode("0011010011010011011010101111110011000011000011000011100011100011100011100011100011100001100100011001000110011100011001001111001111001111001111001111001111"));
        System.out.println(decode("01110111011111000110010011110011110011110011110011110011110111011101110110011001100110011001101111111010101100011001000110000001100000011000"));

    }

    static String[] binaries = new String[] {"10", "11", "0110", "0111", "001100", "001101", "001110", "001111", "00011000", "00011001"};

    public static String code(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < binaries.length; j++) {
                if ((str.charAt(i) + "").equals(j +"")) {
                    result += binaries[j];
                    break;
                }
            }
        }
        return result;
    }
    public static String decode(String str) {
        String result = "";
        while (str.length() > 0) {
            for (int i = 0; i < binaries.length; i++) {
                Pattern p = Pattern.compile("^" + binaries[i] + "");
                Matcher m = p.matcher(str);
                if (m.find()) {
                    str = str.replaceFirst("^" + binaries[i] + "", "");
                    result += i;
                    break;
                }
            }
        }
        return result;
    }


}
