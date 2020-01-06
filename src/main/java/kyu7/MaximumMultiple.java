package kyu7;

/**
 * Created by Behzod on 28, December, 2019
 */
public class MaximumMultiple {
    public static void main(String[] args) {
        System.out.println(maxMultiple(2, 7));
        System.out.println(maxMultiple(3, 10));
        System.out.println(maxMultiple(7, 17));
        System.out.println(maxMultiple(10, 50));
        System.out.println(maxMultiple(37, 200));
        System.out.println(maxMultiple(7, 100));
    }

    public static int maxMultiple(int divisor, int bound) {
        while (bound % divisor != 0) bound--;
        return bound;
    }

    //someone's clever solution
    public static int maxMultiple1(int divisor, int bound) {
        return bound - (bound % divisor);
    }
}
