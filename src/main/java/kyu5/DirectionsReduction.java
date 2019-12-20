package kyu5;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by Behzod on 12, December, 2019
 */
public class DirectionsReduction {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"})));
        System.out.println(Arrays.toString(dirReduc(new String[]{"NORTH", "SOUTH", "EAST", "WEST"})));
        System.out.println(Arrays.toString(dirReduc(new String[]{"NORTH", "SOUTH", "EAST", "WEST"})));
        System.out.println(Arrays.toString(dirReduc(new String[]{"NORTH", "SOUTH", "EAST"})));
        System.out.println(Arrays.toString(dirReduc(new String[]{"NORTH"})));
    }
    //NORTH  - 0, SOUTH - 1, EAST - 2, WEST - 3 (index)
    // 3, 2, 5, 4

    static String[] dirReduc(String[] directions) {
        int[] n = new int[4];
        int[] initial = new int[4];
        for (String dir : directions) {
            if (dir.equals("NORTH")) {
                n[0]++;
                initial[0]++;
            }
            if (dir.equals("SOUTH")) {
                n[1]++;
                initial[1]++;
            }
            if (dir.equals("EAST")) {
                n[2]++;
                initial[2]++;
            }
            if (dir.equals("WEST")) {
                n[3]++;
                initial[3]++;
            }
        }

        if (n[0] - n[1] > 0) {
            n[0] = n[0] - n[1];
            n[1] = 0;
        } else if (n[0] == n[1]) {
            n[0] = 0;
            n[1] = 0;
        } else {
            n[1] = n[1] - n[0];
            n[0] = 0;
        }

        if (n[2] - n[3] > 0) {
            n[2] = n[2] - n[3];
            n[3] = 0;
        } else if (n[2] == n[3]) {
            n[2] = 0;
            n[3] = 0;
        } else {
            n[3] = n[3] - n[2];
            n[2] = 0;
        }
        ArrayList<String> result = new ArrayList<>();
        ArrayList<String> temp = new ArrayList<>();
        for (String s :
                directions) {
            temp.add(s);
        }
        LinkedList<String> linkedList = new LinkedList<>(temp);


            if (linkedList.contains("NORTH")) {
                for (int j = 0; j < initial[0] - n[0]; j++) {
                    linkedList.remove("NORTH");
                }
            }
            if (linkedList.contains("SOUTH")) {
                for (int j = 0; j < initial[1] - n[1]; j++) {
                    linkedList.remove("SOUTH");
                }
            }
            if (linkedList.contains("EAST")) {
                for (int j = 0; j < initial[2] - n[2]; j++) {
                    linkedList.remove("EAST");
                }
            }
            if (linkedList.contains("WEST")) {
                for (int j = 0; j < initial[3] - n[3]; j++) {
                    linkedList.remove("WEST");
                }
            }


        String[] res = new String[linkedList.size()];
        for (int i = 0; i < linkedList.size(); i++) {
            res[i] = linkedList.get(i);
        }
        return res;

        /*for (int i = 0; i < n.length; i++) {
            for (int j = 0; j < n[i]; j++) {
                if (i == 0) {
                    result.add("NORTH");
                    linkedList.remove("NORTH");
                } else if (i == 1) {
                    result.add("SOUTH");
                    linkedList.remove("SOUTH");
                } else if (i == 2) {
                    result.add("EAST");
                    linkedList.remove("EAST");
                } else if(i == 3) {
                    result.add("WEST");
                    linkedList.remove("WEST");
                }
            }
        }*/
    }

    static String[] dirReduc1(String[] dir) {
        int[] dirCount = new int[4];
        for (String s : dir) {
            if (dir.equals("NORTH")) dirCount[0]++;
            if (dir.equals("SOUTH")) dirCount[1]++;
            if (dir.equals("EAST")) dirCount[2]++;
            if (dir.equals("WEST")) dirCount[3]++;
        }

        return new String[]{};
    }
}
