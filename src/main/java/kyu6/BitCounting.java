package kyu6;

/**
 * Created by Behzod on 24, December, 2019
 */
public class BitCounting {
    public static void main(String[] args) {
        System.out.println(countBits(1234));
        System.out.println(countBits(0));
        System.out.println(countBits(1));
        System.out.println(countBits(3));
        System.out.println(countBits(4));
        System.out.println(countBits(7));
        System.out.println(countBits(9));
        System.out.println(countBits(10));
    }

    static int countBits1(int n) {
        String s = Integer.toBinaryString(n);
        if (s.length() == 1) {
            if (s.equals("0")) return 0;
            else return 1;
        }
        if (!s.contains("0")) return s.split("").length;
        return s.contains("1") ? s.split("1").length - 1 : 0;
    }

    static int countBits(int n) {
        String s = Integer.toBinaryString(n);
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') count++;
        }
        return count;
    }
}
