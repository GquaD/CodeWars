package kyu6;

import java.util.Arrays;

/**
 * Created by Behzod on 25, December, 2019
 */
public class AreTheyTheSame {
    public static void main(String[] args) {
        System.out.println(comp(new int[]{121, 144, 19, 161, 19, 144, 19, 11}, new int[]{121, 14641, 20736, 361, 25921, 361, 20736, 361}));
        System.out.println(comp(new int[]{121, 144, 19, 161, 19, 144, 19, 11}, new int[]{131, 14641, 20736, 361, 25921, 361, 20736, 361}));
        System.out.println(comp(new int[]{}, new int[]{}));
        System.out.println(comp(new int[]{0}, new int[]{0}));
        System.out.println(comp(new int[]{-1}, new int[]{1}));
        System.out.println(comp(null, null));
    }

    static boolean comp(int[] nums, int[] squares) {
        if (nums == null || squares == null ) return false;
        if (nums.length == 0 && squares.length == 0) return true;
        if (nums.length == 0 || squares.length == 0) return false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) nums[i] *= -1;
        }
        Arrays.sort(nums);
        Arrays.sort(squares);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] * nums[i] != squares[i]) return false;
        }
        return true;
    }

//not passing 1 test
}


