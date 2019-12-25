package kyu6;

/**
 * Created by Behzod on 24, December, 2019
 */
public class LongestAlphabeticalSubstring {
    public static void main(String[] args) {
        System.out.println(findSubstring("asdfaaaabbbbcttavvfffffdf"));
        System.out.println(findSubstring("abctklmnopaaabbbccc"));
    }

    static String findSubstring(String str) {
        String temp = str.charAt(0) + "";
        String result = "";
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) < str.charAt(i - 1)) {
                if (temp.length() > result.length()) {
                    result = temp;
                    temp = str.charAt(i) + "";
                } else {
                    temp = str.charAt(i) + "";
                }
            } else {
                temp += str.charAt(i);
            }
        }
        if (temp.length() > result.length()) result = temp;
        return result;
    }
}

