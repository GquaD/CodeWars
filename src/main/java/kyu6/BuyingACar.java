package kyu6;

import java.util.Arrays;

/**
 * Created by Behzod on 26, December, 2019
 */
public class BuyingACar {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(nbMonths(2000, 8000, 1000, 1.5)));
        System.out.println(Arrays.toString(nbMonths(12000, 8000, 1000, 1.5)));
    }

    //works!
    public static int[] nbMonths(int startPriceOld, int startPriceNew, int savingperMonth, double percentLossByMonth) {
        double result = -1.0;
        int countMonths = 0;
        double priceOld = startPriceOld, priceNew = startPriceNew;

        if (startPriceOld >= startPriceNew) {
            return new int[]{0, startPriceOld - startPriceNew};
        }

        while (result <= 0) {
            if (percentLossByMonth >= 100) {
                result = savingperMonth * countMonths;
            } else {
                if (countMonths % 2 != 0) percentLossByMonth += 0.5;
                priceOld = priceOld - (priceOld * percentLossByMonth / 100);
                priceNew = priceNew - (priceNew * percentLossByMonth / 100);
                result = priceOld + savingperMonth * (countMonths + 1) - priceNew;
            }
            countMonths++;
        }

        if (priceOld > priceNew) {
            return new int[]{countMonths++, (int) Math.round(priceOld - priceNew)};
        }
        return new int[]{countMonths, (int) Math.round(result)};
    }
}
