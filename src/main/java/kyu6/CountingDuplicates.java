package kyu6;

/**
 * Created by Behzod on 18, December, 2019
 */
public class CountingDuplicates {
    public static void main(String[] args) {
        System.out.println(duplicateCount("abcdea"));
        System.out.println(duplicateCount("abcde"));
        System.out.println(duplicateCount("aabbcde"));
        System.out.println(duplicateCount("aabBcde"));
        System.out.println(duplicateCount("indivisibility"));
        System.out.println(duplicateCount("Indivisibilities"));
        System.out.println(duplicateCount("aA11"));
        System.out.println(duplicateCount("ABBA"));


    }

    public static int duplicateCount(String str) {
        int result = 0;
        String str2 = str;
        String temp = "";
        for (int i = 0; i < str.length(); i++) {
            if ((str.charAt(i) + "").matches("[a-z0-9]")) {
                temp = str2.toLowerCase().replaceFirst(str.charAt(i) + "", "");
                if (temp.contains(Character.toString(str.charAt(i)))) {
                    result++;
                    str2 = temp.replaceAll(str.charAt(i) + "", "");
                }
            }
            if ((str.charAt(i) + "").matches("[A-Z0-9]")) {
                temp = str2.toUpperCase().replaceFirst(str.charAt(i) + "", "");
                if (temp.contains(Character.toString(str.charAt(i)))) {
                    result++;
                    str2 = temp.replaceAll(str.charAt(i) + "", "");
                }
            }

        }
        return result;
    }

    /*int result = 0;
        String str2 = str.toLowerCase();
        String temp = "";
        for (int i = 0; i < str.length(); i++) {
            if ((str.charAt(i) + "").matches("[a-zA-Z0-9]")) {
                temp = str2.replaceFirst(str.charAt(i) + "", "");
            }
            if (temp.contains(Character.toString(str.charAt(i)))) {
                result++;
                str2 = temp.replaceAll(str.charAt(i) + "", "");
            }
        }
        return result;*/
}
