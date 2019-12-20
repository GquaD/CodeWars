package kyu6;

/**
 * Created by Behzod on 16, December, 2019
 */
public class VasyaClerk {
    public static void main(String[] args) {
        System.out.println("8C7FAD2914A217FB973E4B217AF2AB61".toLowerCase());
        System.out.println(tickets2(new int[]{25, 25, 50}));
        System.out.println(tickets2(new int[]{25, 100}));
        System.out.println(tickets2(new int[]{25, 25, 50, 50, 100}));
        System.out.println(tickets2(new int[]{25, 25, 50, 50, 100}));
        System.out.println(tickets2(new int[]{25, 25, 50, 50, 100}));
        System.out.println(tickets2(new int[]{25, 50, 25, 100, 25, 50}));
    }

    static String tickets(int[] line) {
        int countChange = 0; //increment count25s by 1, increment count50s by 2
        int count25 = 0, count50 = 0;
        String result = "YES";
        for (int i = 0; i < line.length; i++) {
            if (line[i] == 25) {
                count25++;
                continue;
            }
            if (line[i] == 50 && countChange > 0) {
                count50++;
                count25--;
                continue;
            } else {
                result = "NO";
                continue;
            }

        }
        return result;
    }

    static String tickets2(int[] line) {
        int count25 = 0, count50 = 0;
        String result = "YES";
        for (int i = 0; i < line.length; i++) {
            if (line[i] == 25) {
                count25++;
                continue;
            } else if (line[i] == 50 && count25 > 0) {
                count25--;
                count50+=2;
                continue;
            } else if (line[i] == 100 && count25 + count50 > 2) {
                if (count50 < 1 && count25 > 2) {
                    count25 -= 3;
                    continue;
                } else if(count25 > 0 && count50 >= 2) {
                    count50 -= 2;
                    count25 -= 1;
                    continue;
                } else {
                    result = "NO";
                    break;
                }
            } else {
                result = "NO";
                break;
            }
        }
        return result;
    }
}
