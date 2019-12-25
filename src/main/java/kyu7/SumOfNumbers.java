package kyu7;

/**
 * Created by Behzod on 24, December, 2019
 */
public class SumOfNumbers {
    public static void main(String[] args) {
        System.out.println(getSum(1, 3));
        System.out.println(getSum(-1, 3));
        System.out.println(getSum(3, 3));
        System.out.println(getSum(1, 2));
        System.out.println(getSum(1, -1));
        System.out.println(getSum(0, -1));

    }

    static int getSum(int a, int b) {
        if (a == b) return a;
        int result = 0;
        if (a < b) {
            for (int i = a; i <= b; i++) {
                result += i;
            }
        } else {
            for (int i = b; i <= a; i++) {
                result += i;
            }
        }
        return result;
    }
}
