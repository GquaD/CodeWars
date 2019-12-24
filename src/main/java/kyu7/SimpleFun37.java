package kyu7;

/**
 * Created by Behzod on 24, December, 2019
 */
public class SimpleFun37 {
    //https://www.codewars.com/kata/58880c6e79a0a3e459000004
    public static void main(String[] args) {
        System.out.println(sum(new int[] {1, 3, 5, 4, 0, 5, 0}));
        System.out.println(sum(new int[] {1, 3, 5, 4, 8, 5, 0}));
        System.out.println(sum(new int[] {0, 3, 5, 4, 0, 5, 0}));
        System.out.println(sum(new int[] {9, 9, 9, 9, 9}));
    }

    static int sum(int[] arr) {
        int result = 0;
        for (int n: arr) {
            if (n > 0) result += n;
            else break;
        }
        return result;
    }
}
