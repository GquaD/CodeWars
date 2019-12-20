package kyu6;

import java.util.Arrays;

/**
 * Created by Behzod on 18, December, 2019
 */
public class PositionsAverage {
    public static void main(String[] args) {
        System.out.println(combinationsNumber(4));

        System.out.println(posAverage("6900690040, 4690606946, 9990494604"));
        System.out.println(posAverage("466960, 069060, 494940, 060069, 060090, 640009, 496464, 606900, 004000, 944096"));
        System.out.println(posAverage("444996, 699990, 666690, 096904, 600644, 640646, 606469, 409694, 666094, 606490"));
        System.out.println(posAverage("4444444, 4444444, 4444444, 4444444, 4444444, 4444444, 4444444, 4444444"));

    }

    public static double posAverage(String s) {
        String[] numbers = s.split(", ");
        String[] temp90 = new String[numbers[0].length()];
        for (int i = 0; i < temp90.length; i++) {
            temp90[i] = "";
        }
        //turning the array to 90 degrees
        for (int i = 0; i < temp90.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                temp90[i] = temp90[i] + numbers[j].charAt(i);
            }
        }
        int count = 0;
        //searching for common positions
        for (int i = 0; i < temp90.length; i++) {
            String temp = temp90[i];
            int tempcount = 0;
            for (int j = 0; j < temp90[0].length(); j++) {
                String compareWithout = temp.replaceFirst(temp.charAt(j) + "", "");
                char currentNumber = temp.charAt(j);
                for (int k = 0; k < compareWithout.length(); k++) {
                    if (compareWithout.charAt(k) == currentNumber) {
                        tempcount++;
                    }
                }
            }
            count += tempcount / 2;

        }
        double result = (count * 1.0) / ((numbers.length * (numbers.length - 1) * numbers[0].length()) / 2);
        result = Double.parseDouble(String.format("%.10f", result * 100));
        return result;
    }

    static int combinationsNumber(int n) {
        if (n == 1) {
            return 1;
        }
        return n + combinationsNumber(n - 1);
    }
}
