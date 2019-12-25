package kyu7;

/**
 * Created by Behzod on 24, December, 2019
 */
public class ShortestWord {
    public static void main(String[] args) {
        System.out.println(shortest("hello what is your name"));
        System.out.println(shortest("is what is your name"));
        System.out.println(shortest("i what is your name"));
    }

    static int shortest(String s) {
        String[] temp = s.split(" ");
        int result = temp[0].length();
        for (int i = 1; i < temp.length; i++) {
            if (temp[i].length() < result) result = temp[i].length();
        }
        return result;
    }
}
