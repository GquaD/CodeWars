package kyu4;

import java.util.Arrays;

/**
 * Created by Behzod on 08, December, 2019
 */
public class Snail {
    //NOT solved yet
    static int[][] array = {{1, 2, 3},
                            {4, 5, 6},
                            {7, 8, 9}};

    static int[][] array1 = {{1, 2, 3},
                             {8,9,4},
                             {7,6,5}};

    static int[][] array2 = {{1, 2, 3, 4},
                            {5, 6, 7, 8},
                            {9, 10, 11, 12},
                            {13, 14, 15, 16}};

    static int[][] array3 = {{1,  2,  3,  4,  5},
                            { 6,  7,  8,  9, 10},
                            {11, 12, 13, 14, 15},
                            {16, 17, 18, 19, 20},
                            {21, 22, 23, 24, 25}};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(snail(array)));
        System.out.println(Arrays.toString(snail(array1)));
        System.out.println(Arrays.toString(snail(array2)));
        System.out.println(Arrays.toString(snail(array3)));
        System.out.println(Arrays.toString(snail(new int[1][0])));
        System.out.println(Arrays.toString(snail(EMPTY)));
    }

    private static final int[][] EMPTY = {{}};

    public static int[] snail(int[][] array) {
        if (array.equals(EMPTY) || array[0].length == 0) return new int[]{};
        int n = array.length * array.length;
        int[] result = new int[n];
        int x = 0, y = 0, count = 0;
        String direction = "R";
        //R - right, D - down, L - left, U - up

        for (int i = 0; i < n; i++) {
            direction = defineDirection(direction, x, y, array);

            if (direction.equals("R")) {
                if (array[x][y] == 0) {
                    x++;
                    y++;
                }
                result[count] = array[x][y];
                array[x][y] = 0;
                y++;
            } else if (direction.equals("D")) {
                if (array[x][y] == 0) {
                    x++;
                    y--;
                }
                result[count] = array[x][y];
                array[x][y] = 0;
                x++;
            } else if (direction.equals("L")) {
                if (array[x][y] == 0) {
                    x--;
                    y--;
                }
                result[count] = array[x][y];
                array[x][y] = 0;
                y--;
            } else {
                if (array[x][y] == 0) {
                    y++;
                    x--;
                }
                result[count] = array[x][y];
                array[x][y] = 0;
                x--;
            }
            count++;
        }
        return result;
    }

    public static String defineDirection(String dir, int x, int y, int[][] array) {
        if (dir.equals("R")) {
            if (array[x][y] == 0 || y >= array.length - 1) {
                return "D";
            } else return "R";
        }
        if (dir.equals("D")) {
            if (array[x][y] == 0 || x >= array[0].length - 1) {
                return "L";
            } else return "D";
        }
        if (dir.equals("L")) {
            if (array[x][y] == 0 || y <= 0) {
                return "U";
            } else return "L";
        }
        if (dir.equals("U")) {
            if (array[x][y] == 0 || x <= 0) {
                return "R";
            } else return "U";
        }
        return dir;
    }

    //someone's clever solution
    public static int[] snail2(int[][] array) {
        if (array[0].length == 0) return new int[0];
        int n = array.length;
        int[] answer = new int[n*n];
        int index=0;
        for (int i = 0; i<n/2; i++){
            for (int j = i; j < n-i; j++) answer[index++] = array[i][j];
            for (int j = i+1; j < n-i; j++) answer[index++] = array[j][n-i-1];
            for (int j = i+1; j < n-i; j++) answer[index++] = array[n-i-1][n-j-1];
            for (int j = i+1; j < n-i-1; j++) answer[index++] = array[n-j-1][i];
        }
        if (n%2 != 0) answer[index++] = array[n/2][n/2];
        return answer;
    }
}
