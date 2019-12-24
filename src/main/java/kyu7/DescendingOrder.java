package kyu7;

import java.util.Arrays;

/**
 * Created by Behzod on 24, December, 2019
 */
public class DescendingOrder {
    public static void main(String[] args) {
        System.out.println(desc(21445));
        System.out.println(desc(145263));
        System.out.println(desc(123456789));
    }

    static int desc(int n) {
        char[] s = (n + "").toCharArray();
        Arrays.sort(s);
        String result = "";
        for (int i = s.length - 1; i >= 0 ; i--) {
            result += s[i] + "";
        }
        return Integer.parseInt(result);
    }
}
