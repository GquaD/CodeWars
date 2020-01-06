package kyu4;

/**
 * Created by Behzod on 18, December, 2019
 */
public class ShortestKnightPath {
    //NOT solved yet
    public static void main(String[] args) {

    }

    public static int knight(String start, String  finish) {
        char startLetter = start.charAt(0);
        int startNumber = start.charAt(1);
        char finishLetter = finish.charAt(0);
        int finishNumber = finish.charAt(1);
        int temp = Math.abs(startNumber - finishNumber) + Math.abs(startLetter - finishLetter);



        return 1;
    }
}
