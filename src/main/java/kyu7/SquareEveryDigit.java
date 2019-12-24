package kyu7;

/**
 * Created by Behzod on 24, December, 2019
 */
public class SquareEveryDigit {
    public static void main(String[] args) {
        System.out.println(squareDigit(9119));
        System.out.println(squareDigit(818));
        System.out.println(squareDigit(12345));
    }

    static int squareDigit(int n) {
        String temp = String.valueOf(n), result = "";
        for (int i = 0; i < temp.length(); i++) {
            result += (int) Math.pow(Character.getNumericValue(temp.charAt(i)), 2);
        }
        return Integer.parseInt(result);
    }
}
