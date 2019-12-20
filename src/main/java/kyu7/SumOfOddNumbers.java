package kyu7;

/**
 * Created by Behzod on 18, December, 2019
 */
public class SumOfOddNumbers {
    public static void main(String[] args) {
        System.out.println(rowSumOddNumbers(1));
        System.out.println(rowSumOddNumbers(2));
        System.out.println(rowSumOddNumbers(3));
        System.out.println(rowSumOddNumbers(4));
        System.out.println(rowSumOddNumbers(5));
        System.out.println(rowSumOddNumbers(6));
        System.out.println(rowSumOddNumbers(7));
    }

    public static int rowSumOddNumbers(int n) {
        int start = (int) (n + Math.pow(n - 1, 2));
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += start;
            start +=2;
        }
        return result;
    }

    public static int rowSumOddNumbers2(int n) {
        return n*n*n;
    }
}
