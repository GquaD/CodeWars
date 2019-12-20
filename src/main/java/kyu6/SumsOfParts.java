package kyu6;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Behzod on 17, December, 2019
 */
public class SumsOfParts {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(parts_sum(new long[] {0, 1, 3, 6, 10})));
        System.out.println(Arrays.toString(parts_sum(new long[] {1, 2, 3, 4, 5, 6})));
        System.out.println(Arrays.toString(parts_sum(new long[] {744125, 935, 407, 454, 430, 90, 144, 6710213, 889, 810, 2579358})));

        System.out.println(Arrays.toString(parts_sum1(new long[] {0, 1, 3, 6, 10})));
        System.out.println(Arrays.toString(parts_sum1(new long[] {1, 2, 3, 4, 5, 6})));
        System.out.println(Arrays.toString(parts_sum1(new long[] {744125, 935, 407, 454, 430, 90, 144, 6710213, 889, 810, 2579358})));

        System.out.println(Arrays.toString(parts_sum2(new int[] {0, 1, 3, 6, 10})));
        System.out.println(Arrays.toString(parts_sum2(new int[] {1, 2, 3, 4, 5, 6})));
        System.out.println(Arrays.toString(parts_sum2(new int[] {744125, 935, 407, 454, 430, 90, 144, 6710213, 889, 810, 2579358})));
        System.out.println("//////////////////////////////////////////");
        System.out.println(Arrays.toString(parts_sum3(new int[] {0, 1, 3, 6, 10})));
        System.out.println(Arrays.toString(parts_sum3(new int[] {1, 2, 3, 4, 5, 6})));
        System.out.println(Arrays.toString(parts_sum3(new int[] {744125, 935, 407, 454, 430, 90, 144, 6710213, 889, 810, 2579358})));
    }

    static long[] parts_sum(long[] nums) {
        ArrayList<Long> list = new ArrayList<>();
        ArrayList<Long> listResult = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        long sum = 0;
        for (int i = nums.length; i >= 0; i--) {
            for (int j = nums.length - 1; j >= i; j--) {
                sum += list.get(j);
            }
            listResult.add(sum);
            sum = 0;
        }
        long[] result = new long[listResult.size()] ;
        for (int i = 0; i < listResult.size(); i++) {
            result[i] = listResult.get(i);
        }
        return result;
    }

    static long[] parts_sum1(long[] nums) {
        ArrayList<Long> list = new ArrayList<>();
        ArrayList<Long> listResult = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        long sum = 0;
        for (int i = 0; i <= nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                sum += list.get(j);
            }
            listResult.add(sum);
            sum = 0;
        }
        long[] result = new long[listResult.size()] ;
        for (int i = 0; i < listResult.size(); i++) {
            result[i] = listResult.get(i);
        }
        return result;
    }

//this method works but when array has 150 000 and more member, it takes too much time
    static int[] parts_sum2(int[] nums) {
        int[] res = new int[nums.length + 1];
        int sum = 0;
        for (int i = 0; i <= nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
            }
            res[i] = sum;
            sum = 0;
        }
        return res;
    }

    static int[] parts_sum4(int[] nums) {
        int[] res = new int[nums.length + 1];
        int sum = 0;
        res[res.length - 1] = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[nums.length - i - 1];
            res[nums.length - i - 1] = sum;
        }
        return res;
    }

    static int[] parts_sum3(int[] nums) {
        int[] res = new int[nums.length + 1];
        int sum = 0;
        res[res.length - 1] = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            sum += nums[i];
            res[i] = sum;
        }
        return res;
    }

}
