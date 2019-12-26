package kyu6;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Behzod on 25, December, 2019
 */
public class TheSupermarketQueue {
    public static void main(String[] args) {
        System.out.println(solveSuperMarketQueue(new int[] { 2, 2, 3, 3, 4, 4 }, 2));
        System.out.println(solveSuperMarketQueue(new int[] { 1, 2, 3, 4, 5 }, 1));
        System.out.println(solveSuperMarketQueue(new int[] { 10, 2, 3, 3 }, 2));
        System.out.println(solveSuperMarketQueue(new int[] { 2, 3, 10 }, 2));
        System.out.println(solveSuperMarketQueue(new int[] { 2, 6, 4, 5, 1, 8 }, 3));
        System.out.println(solveSuperMarketQueue(new int[] {}, 1));
        System.out.println(solveSuperMarketQueue(new int[] {1, 3}, 2));
        System.out.println(solveSuperMarketQueue(new int[] { 1, 2, 3, 4, 5 }, 1));

        System.out.println("//////////////////////////////////////////");

        System.out.println(solveSuperMarketQueue1(new int[] { 2, 2, 3, 3, 4, 4 }, 2));
        System.out.println(solveSuperMarketQueue1(new int[] { 1, 2, 3, 4, 5 }, 1));
        System.out.println(solveSuperMarketQueue1(new int[] { 10, 2, 3, 3 }, 2));
        System.out.println(solveSuperMarketQueue1(new int[] { 2, 3, 10 }, 2));
        System.out.println(solveSuperMarketQueue1(new int[] { 2, 6, 4, 5, 1, 8 }, 3));
        System.out.println(solveSuperMarketQueue1(new int[] {}, 1));
        System.out.println(solveSuperMarketQueue1(new int[] {1, 3}, 2));
        System.out.println(solveSuperMarketQueue1(new int[] { 1, 2, 3, 4, 5 }, 1));
    }

    public static int solveSuperMarketQueue(int[] customers, int n) {
        if (customers.length < 1) return 0;
        if (n >= customers.length){
            return findMax(customers);
        }

        int[] linesCurrent = new int[n];
        ArrayList<Integer> customersList = new ArrayList<>(customers.length);
        for (int i = 0; i < customers.length; i++) {
            customersList.add(customers[i]);
        }

        //initial filling up linesCurrent
        for (int i = 0; i < linesCurrent.length; i++) {
            linesCurrent[i] = customersList.get(0);
            customersList.remove(0);
        }
        int result = 0;
        do {
            int minInLine = findMin(linesCurrent);

            for (int i = 0; i < linesCurrent.length; i++) {
                linesCurrent[i] -= minInLine;
            }
            result += minInLine;

            for (int i = 0; i < linesCurrent.length; i++) {
                if (linesCurrent[i] == 0) {
                    if (customersList.size() > 0) {
                        linesCurrent[i] += customersList.get(0);
                        customersList.remove(0);
                    } else {
                        result += findMax(linesCurrent);
                        for (int j = 0; j < linesCurrent.length; j++) {
                            linesCurrent[j] = 0;
                        }
                        break;
                    }
                }
            }
        } while (customersList.size() > 0 || !isAllZero(linesCurrent));
        return result;
    }

    static int findMin(int[] nums) {
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (min > nums[i]) {
                min = nums[i];
            }
        }
        return min;
    }

    static int findMax(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
            }
        }
        return max;
    }

    static boolean isAllZero(int[] n) {
        for (int i = 0; i < n.length; i++) {
            if (n[i] != 0) return false;
        }
        return true;
    }


    //not my solutions, clever solution by user

    public static int solveSuperMarketQueue1(int[] customers, int n) {
        int[] result = new int[n];
        for(int i = 0; i < customers.length; i++){
            result[0] += customers[i];
            Arrays.sort(result);
        }
        return result[n-1];
    }
}
