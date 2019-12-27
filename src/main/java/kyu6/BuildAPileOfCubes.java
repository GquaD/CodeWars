package kyu6;

/**
 * Created by Behzod on 26, December, 2019
 */
public class BuildAPileOfCubes {

    public static void main(String[] args) {
        System.out.println(findNb(1071225));
        System.out.println(findNb(225));
        System.out.println(findNb(91716553919377L));
        System.out.println(findNb(4183059834009L));
        System.out.println(findNb(24723578342962L));
        System.out.println(findNb(135440716410000L));
        System.out.println();
        System.out.println(findNb(2117823215476775625L));
        System.out.println(findNb(1891642988994736384L));
        System.out.println(findNb(1655180475732330625L));
        System.out.println(findNb(1695748438550501722L));
        System.out.println(findNb(1695748438550491904L));
        System.out.println();
        System.out.println(findCub(51033));
        System.out.println(findCub(5));
        System.out.println(findCub(54353));
    }


    public static long findNb(long num) {
        long m = (long) Math.sqrt(num);
        long result = 0;
        if (m * m != num) return -1;
        while (m > result) {
            result += 1;
            m -= result;
        }
        if (m == 0) return result;
        else return -1;
    }
    //done!


    static long findCub(long num) {
        long result = 0;
        for (int i = 1; i <= num; i++) {
            result += Math.pow(i, 3);
        }
        return result;
    }

    //someone's clever solution
    public static long findNb1(long m) {
        long mm = 0, n = 0;
        while (mm < m) mm += ++n * n * n;
        return mm == m ? n : -1;
    }
}
