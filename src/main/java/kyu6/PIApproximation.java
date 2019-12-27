package kyu6;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Created by Behzod on 27, December, 2019
 */
public class PIApproximation {
    public static void main(String[] args) {
        System.out.println(iterPi2String(0.1));
        System.out.println(iterPi2String(0.001));
        System.out.println(iterPi2String(0.000001));
        System.out.println("///////////////////");
        System.out.println(iterPi2String2(0.1));
        System.out.println(iterPi2String2(0.001));
        System.out.println(iterPi2String2(0.000001));
    }

    public static String iterPi2String(Double epsilon) {
        long iterations = (long) Math.round(epsilon / (epsilon * epsilon));
        long start = 1;
        double result = 0;
        if (iterations > 10000) {
            iterations++;
        }
        for (int i = 0; i < iterations; i++) {
            result += (1.0 / start) * Math.pow(-1, i);
            start+=2;
        }
        result *= 4;
        DecimalFormat df = new DecimalFormat("#.##########");
        df.setRoundingMode(RoundingMode.HALF_UP);
        return "[" + iterations + ", " + df.format(result) + "]";
    }

    public static String iterPi2String2(Double epsilon) {
        String[] split = (epsilon + "").split("\\.");
        int approximation = split[1].length() - 1;
        double result = 0;
        String strPI = String.format("%." + approximation + "f", Math.PI);
        String strRes = "";
        long count = 0, start = 1;
        while (!strRes.equals(strPI)) {
            result += (1.0 / start) * Math.pow(-1, count);
            count++;
            start+=2;
            strRes = String.format("%." + approximation + "f", result * 4);
        }
        strRes = String.format("%.10f", result * 4);
        return  "[" + count + ", " + strRes + "]";
    }

    //someones clever solution
    public static String iterPi2String3(Double epsilon) {
        int i = 0, j = 1;
        double pi = 0.0;
        while( Math.abs(Math.PI - pi*4) > epsilon) {
            if(i % 2 == 0) pi += 1.0/j;
            else pi -= 1.0/j;
            j += 2;
            i++;
        }
        return String.format("[%d, %.10f]", i, pi*4);
    }
}
