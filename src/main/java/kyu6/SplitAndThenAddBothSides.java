package kyu6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Behzod on 25, December, 2019
 */
public class SplitAndThenAddBothSides {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(splitAndAdd(new int[]{1,2,3,4,5},2)));
        System.out.println(Arrays.toString(splitAndAdd(new int[]{1,2,3,4,5},3)));
        System.out.println(Arrays.toString(splitAndAdd(new int[]{15},3)));
        System.out.println(Arrays.toString(splitAndAdd(new int[]{32,45,43,23,54,23,54,34},2)));
        System.out.println(Arrays.toString(splitAndAdd(new int[]{32,45,43,23,54,23,54,34},0)));
        System.out.println(Arrays.toString(splitAndAdd(new int[]{3,234,25,345,45,34,234,235,345},3)));
        System.out.println(Arrays.toString(splitAndAdd(new int[]{3,234,25,345,45,34,234,235,345,34,534,45,645,645,645,4656,45,3},4)));
        System.out.println(Arrays.toString(splitAndAdd(new int[]{23,345,345,345,34536,567,568,6,34536,54,7546,456},20)));
    }

    //my solution, worked!
    public static int[] splitAndAdd1(int[] numbers, int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);
        }
        int count = 0;
        while (list.size() != 1 && count++ != n) {
            int tempHalfSize = list.size() / 2;
            for (int i = 0; i < tempHalfSize; i++) {
                list.set((list.size() - tempHalfSize) + i, list.get(0) + list.get((list.size() - tempHalfSize) + i));
                list.remove(0);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i).intValue();
        }
        return result;

    }

    //someone's interesting solution
    public static int[] splitAndAdd(int[] numbers, int n) {
        int[] arr = Arrays.copyOf(numbers, numbers.length);
        while (arr.length > 1 && n-- > 0) {
            int[] tmp = Arrays.copyOfRange(arr, arr.length/2, arr.length);
            for (int i = 0 ; i < arr.length/2 ; i++) tmp[i + arr.length%2] += arr[i];
            arr = tmp;
        }
        return arr;
    }
}


       /*
        */

