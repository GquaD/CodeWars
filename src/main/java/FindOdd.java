import java.util.*;

public class FindOdd {
    public static int findIt(int[] a) {
        int result = 0;
        ArrayList<Integer> occurences = new ArrayList<>();
        ArrayList<Integer> integerArrayList = new ArrayList<>();

        for (int i = 0; i < a.length; i++) {
            integerArrayList.add(a[i]);
        }

        for (int i = 0; i < integerArrayList.size(); i++) {
            occurences.add(Collections.frequency(integerArrayList, integerArrayList.get(i)));

        }

        for (int i = 0; i < occurences.size(); i++) {
            if (occurences.get(i).intValue() % 2 == 1) {
                result = integerArrayList.get(i);
            }
        }
        return result;
    }

    public static int findIt1(int[] A) {
        int xor = 0;
        for (int i = 0; i < A.length; i++) {
            xor ^= A[i];
        }
        return xor;
    }
}
