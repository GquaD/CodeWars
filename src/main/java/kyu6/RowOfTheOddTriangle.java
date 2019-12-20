package kyu6;

import java.util.Arrays;

/**
 * Created by Behzod on 18, December, 2019
 */
public class RowOfTheOddTriangle {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(oddRow(1)));
        System.out.println(Arrays.toString(oddRow(2)));
        System.out.println(Arrays.toString(oddRow(3)));
        System.out.println(Arrays.toString(oddRow(4)));
        System.out.println(Arrays.toString(oddRow(5)));
        System.out.println(Arrays.toString(oddRow(6)));
        System.out.println(Arrays.toString(oddRow(7)));

    }

    static int[] oddRow(int n) {
        int res[] = new int[n];
        int start = (int) (n + Math.pow(n - 1, 2));
        for (int i = 0; i < n; i++) {
            res[i] = start;
            start +=2;
        }
        return res;
    }
}
