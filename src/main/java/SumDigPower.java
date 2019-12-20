import java.util.ArrayList;
import java.util.List;

public class SumDigPower {
    public static List<Long> sumDigPow(long a, long b) {
        ArrayList<Long> list = new ArrayList<>();
        for (long i = a; i <= b; i++) {
            int power = String.valueOf(i).length();
            if (i == doEureka(i, power)) {
                list.add(i);
            }
        }
        return list;

    }

    static long doEureka(long number, int pow) {
        if (number % 10 == number) {
            return (long) Math.pow(number, pow);
        } else {
            return (long)(Math.pow(number % 10, pow)) + doEureka(number / 10, pow - 1);
        }
    }

    public static void main(String[] args) {
        //System.out.println(doEureka(90L, 2));
        System.out.println(sumDigPow(50, 88));
    }
}
