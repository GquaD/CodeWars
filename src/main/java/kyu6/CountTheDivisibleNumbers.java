package kyu6;

/**
 * Created by Behzod on 12, December, 2019
 */
public class CountTheDivisibleNumbers {
    public static void main(String[] args) {
        System.out.println(count(6, 11, 2));
        System.out.println(count(7, 7, 3));
        System.out.println(count(6, 11, 5));
    }

    static long count(long x, long y, long k) { //5 and 11, diff = 6, 6
        long count = 0;
        for (long i = x; i <= y; i++) {
            if (i % k == 0) {
                x = i;
                break;
            }
        }

        for (long i = y; i >= x; i--) {
            if (i % k == 0) {
                y = i;
                break;
            }
        }

        long diff = y - x;
        if (diff == k)
            count = diff / k + 1;
        else if (x == y) {
            if (x % k != 0) {
                count = 0;
            } else {
                count = 1;
            }
        } else
            count = diff / k + 1;
        return count;
    }
}
