package kyu6;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayList;

/**
 * Created by Behzod on 25, December, 2019
 */
public class ReversingAProcess {
    public static void main(String[] args) {
        System.out.println(decode("6015ekx"));
        System.out.println(decode("5057aan"));
    }

    static String decode(String str) {
        int key = Integer.parseInt(str.replaceAll("[^0-9]", ""));
        String textToDecode = str.toLowerCase().replaceAll("[^a-z]", "");
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        String result = "";
        int tempIndex = 0;
        for (int i = 0; i < textToDecode.length(); i++) {
            for (int j = 0; j < alphabet.length; j++) {
                if (textToDecode.charAt(i) == alphabet[j]) {
                    tempIndex = j;
                    break;
                }
            }

            for (int j = 0; j < alphabet.length; j++) {
                if (key * j % 26 == tempIndex) {
                    result += alphabet[j] + "";
                }
            }
        }

        if (result.length() != textToDecode.length()) return "Impossible to decode";
        else return result;
    }
}
