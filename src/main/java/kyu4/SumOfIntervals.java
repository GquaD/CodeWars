package kyu4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Behzod on 20, December, 2019
 */
public class SumOfIntervals {
    //NOT solved yet
    public static void main(String[] args) {
        System.out.println(sumIntervals(new int[][]{{1, 3}, {4, 8}, {1, 5}}));
    }

    public static int sumIntervals(int[][] intervals) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < intervals.length; i++) {
            int first = intervals[i][0], second = intervals[i][1];
            if (map.containsKey(first)) {
               if (map.get(first) < second) map.put(first, second);
            } else {
                map.put(first, second);
            }
        }

        int counting = 0;
        int[] sorting = new int[map.size()];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            sorting[counting] = entry.getKey();
            counting++;
        }

        Arrays.sort(sorting);

        int[][] cleared = new int[map.size()][2];
        for (int i = 0; i < map.size(); i++) {
            cleared[i][0] = sorting[i];
            cleared[i][1] = map.get(sorting[i]);
        }
        int a = cleared[0][0];
        int b = cleared[0][1];
        for (int i = 0; i < cleared.length * 2 - 1; i++) {
            if (a >= b){

            } else {

            }
        }

        /*int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            cleared[count][0] = entry.getKey();
            cleared[count][1] = entry.getValue();
            count++;
        }*/


        return -1;
    }
}
