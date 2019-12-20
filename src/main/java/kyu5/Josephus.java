package kyu5;

import java.util.*;

/**
 * Created by Behzod on 13, December, 2019
 */
public class Josephus {
    public static void main(String[] args) {
        List<Integer> sample = new ArrayList<>();
        sample.add(1);
        sample.add(2);
        sample.add(3);
        sample.add(4);
        sample.add(5);
        sample.add(6);
        sample.add(7);
        sample.add(8);
        sample.add(9);
        sample.add(10);
        sample.add(11);
        sample.add(12);
        sample.add(13);
        System.out.println(Arrays.toString(josephus(7, 3)));
        System.out.println(Arrays.toString(josephus(7, 4)));
        System.out.println(Arrays.toString(josephus(13, 4)));
       /* System.out.println(Arrays.toString(josephus3(sample, 4)));
        System.out.println(Arrays.toString(josephus3(13, 4)));
        System.out.println(Arrays.toString(josephus3(13, 4)));*/
    }

    static int[] josephus(int n, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<Integer> result = new LinkedList<>();
        int count = 0;
        for (int i = 1; i <= n; i++) {
            list.add(++count);
        }

        count = 1;
        int cycle = 1;
        while (list.size() >= 1) {
            if (count % k == 0) {
                if (cycle <= list.size()) {
                    result.add(list.get(cycle - 1));
                    list.remove(list.get(cycle - 1));
                    cycle--;
                } else {
                    result.add(list.get(cycle - 1));
                    list.remove(list.get(cycle - 1));
                    cycle = 1;
                }
            }
            if (cycle == list.size()) {
                cycle = 0;
            }
            cycle++;
            count++;
        }
        int[] res = new int[result.size()];


        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }

        return res;
    }

    static int[] josephus2(int n, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, i);
        }
        LinkedList<Integer> list = new LinkedList<>();
        int index = 1, counter = 1, cycle = 1;
        while (index <= n) {
            if (counter % k == 0) {
                if (map.get(index) == 0) {
                    counter--;
                    continue;
                } else {
                    list.add(map.get(counter));
                    map.put(index, 0);
                    counter = 0;
                    index++;
                }
            }
            counter++;
        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    static String josephus2(int[] n, int k) {
        int[][] gen = new int[n.length][k];
        return "";
    }

    static <T> List<T> josephus3(final List<T> n, final int k) {
        List<T> result = new LinkedList<>();
        int count = 1;
        int cycle = 1;
        while (n.size() >= 1) {
            if (count % k == 0) {
                if (cycle <= n.size()) {
                    result.add(n.get(cycle - 1));
                    n.remove(n.get(cycle - 1));
                    cycle--;
                } else {
                    result.add(n.get(cycle - 1));
                    n.remove(n.get(cycle - 1));
                    cycle = 1;
                }
            }
            if (cycle == n.size()) {
                cycle = 0;
            }
            cycle++;
            count++;
        }

        List<T> resres = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            resres.add((T) result.get(i));
        }

        return resres;
    }

}
