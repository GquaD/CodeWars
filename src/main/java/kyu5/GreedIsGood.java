package kyu5;

import java.util.Arrays;

/**
 * Created by Behzod on 12, December, 2019
 */
public class GreedIsGood {
    public static void main(String[] args) {
        System.out.println(count(new int[] {5, 1, 3, 4, 1}));
        System.out.println(count(new int[] {1, 1, 1, 3, 1}));
        System.out.println(count(new int[] {2, 4, 4, 5, 4}));
        System.out.println(count(new int[] {6, 1, 6, 3, 6}));
    }

    static int count1(int[] numbers) {
        int result = 0;
        Arrays.sort(numbers);
        String str = "";
        for (int i = 0; i < numbers.length; i++) {
            str += numbers[i];

        }
        if (str.contains("111")) {
            result += 1000;
            str = str.replaceFirst("^([1][1][1])", "");
        }
        if (str.contains("666")) {
            result += 600;
            str = str.replaceFirst("([6][6][6])", "");
        }
        if (str.contains("555")) {
            result += 500;
            str = str.replaceFirst("([5][5][5])", "");
        }
        if (str.contains("444")) {
            result += 400;
            str = str.replaceFirst("([4][4][4])", "");
        }
        if (str.contains("333")) {
            result += 300;
            str = str.replaceFirst("([3][3][3])", "");
        }
        if (str.contains("222")) {
            result += 200;
            str = str.replaceFirst("([2][2][2])", "");
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                result += 100;
                str.replace("1", "");
            }
            if (str.charAt(i) == '5') {
                result += 50;
                str.replace("5", "");
            }
        }
        return result;
    }


    public static int count(int[] dice) {
        int n[] = new int[7];
        for (int d : dice) n[d]++;
        return n[1]/3*1000 + n[1]%3*100 + n[2]/3*200 + n[3]/3*300 + n[4]/3*400 + n[5]/3*500 + n[5]%3*50 + n[6]/3*600;
    }
}
