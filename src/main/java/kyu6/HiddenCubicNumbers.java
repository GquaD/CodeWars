package kyu6;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Behzod on 25, December, 2019
 */
public class HiddenCubicNumbers {
    public static void main(String[] args) {
        System.out.println(isSumOfCubes("53"));
        System.out.println(isSumOfCubes("aqdf& 0 1 xyz 153 777.777"));
        System.out.println(isSumOfCubes("QK29 45[&erui"));
        System.out.println(isSumOfCubes("0 9026315 -827&()"));
    }

    public static String isSumOfCubes(String s) {
        ArrayList<Integer> resultList = new ArrayList<>();
        String str = s.replaceAll("[^\\d.]", ".");
        String[] arr = str.split("\\.");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) continue;
            String tempNum = arr[i];
            while (tempNum.length() > 0) {
                if (tempNum.length() > 2) {
                    int checkCubic = Integer.parseInt(tempNum.substring(0, 3));
                    if (isCubic(checkCubic)) {
                        resultList.add(checkCubic);
                    }
                    tempNum = tempNum.replaceFirst(""+checkCubic, "");
                } else {
                    int checkCubic = Integer.parseInt(tempNum);
                    if (isCubic(checkCubic)) {
                        resultList.add(checkCubic);
                    }
                    tempNum = tempNum.replaceFirst(""+checkCubic, "");
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        if (resultList.size() > 0) {
            int sum = 0;
            for (int i = 0; i < resultList.size(); i++) {
                sb.append(resultList.get(i) + " ");
                sum += resultList.get(i);
            }
            sb.append(sum + " Lucky");
        } else {
            sb.append("Unlucky");
        }

        return sb.toString();
    }

    public static boolean isCubic(int num) {
        int one = num / 100;
        int two = (num % 100) / 10;
        int three = (num % 100) % 10;
        return one * one * one + two * two * two + three * three * three == num ? true : false;
    }
}
