package kyu6;

import java.util.Arrays;

/**
 * Created by Behzod on 16, December, 2019
 */
public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3}, 4)));
    }

    static int[] twoSum(int[] array, int target) {
        int[] result = new int[2];
        outerloop:
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i] + array[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    break outerloop;
                }
            }
        }
        return result;
    }
}
