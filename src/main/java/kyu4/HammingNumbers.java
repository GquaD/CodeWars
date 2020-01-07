package kyu4;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Behzod on 06, January, 2020
 */
public class HammingNumbers {
    static ArrayList<Long> list = new ArrayList<>();
    public static void main(String[] args) {
        LocalDateTime time = LocalDateTime.now();
        System.out.println(time);
        System.out.println(hamming(1));
        System.out.println(hamming(2));
        System.out.println(hamming(3));
        System.out.println(hamming(4));
        System.out.println(hamming(5));
        System.out.println(hamming(6));
        System.out.println(hamming(7));
        System.out.println(hamming(10));
        System.out.println(hamming(15));
        System.out.println(hamming(19));
        System.out.println(hamming(5000));
        System.out.println(LocalDateTime.now());
    }

    public static long hamming(int n) {
        ArrayList<Long> nums = new ArrayList<>();
        int limit = (int) (Math.sqrt(n)+1);
        aa:
        for (int i = 0; i <= limit; i++) {
            for (int j = 0; j <= limit; j++) {
                for (int k = 0; k <= limit; k++) {
                    nums.add(generateHammingNumber(i, j, k));
                    //if (nums.size() >= n*n*2) break aa;
                }
            }
        }
        Collections.sort(nums);
        return nums.get(n - 1);
    }

    public static long generateHammingNumber(int i, int j, int k) {
        double result = Math.pow(2, i) * Math.pow(3, j) * Math.pow(5, k);
        return (long) result;
    }


//someone's clever solution
    public static long hamming1(int n) {
        long[] h = new long[n];
        h[0] = 1;
        long x2 = 2, x3 = 3, x5 = 5;
        int i = 0, j = 0, k = 0;

        for (int index = 1; index < n; index++) {
            h[index] = Math.min(x2, Math.min(x3, x5));
            if (h[index] == x2) x2 = 2 * h[++i];
            if (h[index] == x3) x3 = 3 * h[++j];
            if (h[index] == x5) x5 = 5 * h[++k];
        }

        return h[n - 1];
    }

    public static long genHamNumber2(int i) {
        if (i < 0) return 1;
        return (long) (genHamNumber2(i) * Math.pow(2, i - 1));
    }
    public static long genHamNumber3(int j) {
        if (j < 0) return 1;
        return (long) (genHamNumber3(j) * Math.pow(3, j - 1));
    }
    public static long genHamNumber5(int k) {
        if (k < 0) return 1;
        return (long) (genHamNumber5(k) * Math.pow(5, k - 1));
    }

}
