package kyu6;

/**
 * Created by Behzod on 24, December, 2019
 */
public class FindTheParityOutlier {
    public static void main(String[] args) {
        System.out.println(findParity(new int[] {2, 4, 0, 100, 4, 11, 2602, 36}));
        System.out.println(findParity(new int[] {160, 3, 1719, 19, 11, 13, -21}));
        System.out.println(findParity(new int[] {2,6,8,-10,3}));
        System.out.println(findParity(new int[] {206847684,1056521,7,17,1901,21104421,7,1,35521,1,7781}));
        System.out.println(findParity(new int[] {Integer.MAX_VALUE, 0, 1}));
    }

    static int findParity(int[] arr) {
        int countOdd = 0, countEven = 0;
        String nums = "";
        int length = 0;

        if (arr.length > 4) length = 4;
        else length = arr.length;

        for (int i = 0; i < length; i++) {
            if (arr[i] % 2 == 0) countEven++;
            else countOdd++;
        }

        if (countEven > 1) nums = "even";
        else nums = "odd";

        int result = 0;
        if (nums.equals("even")) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] % 2 != 0) result = arr[i];
            }
        } else if (nums.equals("odd")) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] % 2 == 0) result = arr[i];
            }
        }
        return result;
    }
}
