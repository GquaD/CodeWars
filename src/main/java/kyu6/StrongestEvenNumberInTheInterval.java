package kyu6;

/**
 * Created by Behzod on 17, December, 2019
 */
public class StrongestEvenNumberInTheInterval {
    public static void main(String[] args) {
        System.out.println(findStrongestEven(1, 2));
        System.out.println(findStrongestEven(5, 10));
        System.out.println(findStrongestEven(48, 56));
        System.out.println(findStrongestEven(129, 193));

        System.out.println(findStrongestEven1(1, 2));
        System.out.println(findStrongestEven1(5, 10));
        System.out.println(findStrongestEven1(48, 56));
        System.out.println(findStrongestEven1(2147480000, 2147483647));
    }

    static int findStrongestEven(int n, int m) {
        int strongest = 0, timesTemp = 0;
        if (n % 2 != 0) n++;
        for (int i = n; i <= m; i += 2) {
            int number = i, times = 0;


            while (number % 2 == 0) {
                number /= 2;
                times++;
            }
            if (times > timesTemp && i > strongest) {
                strongest = i;
                timesTemp = times;
            }
        }
        return strongest;
    }
    //write method which will have for loop

    static int findStrongestEven1(int n, int m) {
        int times = 0;
        int number = n, temp;
        if (number % 2 != 0) {
            number++;
            n++;
        }
        //finding first even number and its times divided to 2
//        times = findTimes(n);
//        temp = (int) Math.pow(2, times);
        while (number <= m) {
            times = findTimes(number);
            temp = (int) Math.pow(2, times);
            if (number + temp < 0) break;
            number += temp;
        }
        if (number > m) {
            return number - (int) Math.pow(2, times);
        } else {
            return number;
        }
    }

    static int findTimes(int num) {
        int times = 0;
        while (num % 2 == 0) {
            num /= 2;
            times++;
        }
        return times;
    }


    static int findStrongestEven2(int n, int m) {

        return 1;
    }
}
