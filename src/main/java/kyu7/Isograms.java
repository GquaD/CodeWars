package kyu7;


/**
 * Created by Behzod on 24, December, 2019
 */
public class Isograms {
    //https://www.codewars.com/kata/54ba84be607a92aa900000f1
    public static void main(String[] args) {
        System.out.println(isIsogram("Aba"));
        System.out.println(isIsogram("Dermatoglyphics"));
        System.out.println(isIsogram("moOse"));
    }

    static boolean isIsogram(String s) {
        s = s.toLowerCase();
        String temp = "";
        for (int i = 0; i < s.length(); i++) {
            temp = s.replaceFirst(s.charAt(i) + "", "");
            if (temp.contains(s.charAt(i) + "")) {
                return false;
            }
        }
        return true;
    }
}
