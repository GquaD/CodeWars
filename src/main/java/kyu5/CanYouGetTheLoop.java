package kyu5;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * Created by Behzod on 12, December, 2019
 */
public class CanYouGetTheLoop {
    public static void main(String[] args) {
        System.out.println(add(210, 210));
        System.out.println(add(1.5, 1.6));
        System.out.println(add(1.001, 1));
    }
    static double add(double x, double y) {
        BigDecimal xB = new BigDecimal(x);
        BigDecimal xY = new BigDecimal(y);
        BigDecimal result = xB.add(xY);

        double res = Double.parseDouble(result.toString());
        res = Math.floor(res * 100 / 100);
        DecimalFormat df = new DecimalFormat("#.##");
        res = Double.parseDouble(df.format(res));
        return res;
    }
}
