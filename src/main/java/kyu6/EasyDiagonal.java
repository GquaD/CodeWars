package kyu6;

import java.math.BigInteger;

/**
 * Created by Behzod on 25, December, 2019
 */
public class EasyDiagonal {
    public static void main(String[] args) {
        System.out.println(sumFracts(20, 3));
        System.out.println(sumFracts(20, 4));
        System.out.println(sumFracts(7, 0));
        System.out.println(sumFracts(7, 1));
        System.out.println(sumFracts(7, 2));
    }

    public static BigInteger sumFracts(int n, int k) {
        BigInteger result = BigInteger.ZERO;
        for (int i = 0; i < n - k + 1; i++) {
            result = result.add(concreteCoef(new BigInteger((n - i) + ""), k));
        }
        return result;
    }

    static BigInteger concreteCoef(BigInteger n, int k) {
        BigInteger temp = BigInteger.ONE;
        for (int i = 0; i < k; i++) {
            temp = temp.multiply(n.subtract(new BigInteger(i + "")));
        }
        return temp.divide(new BigInteger(factorial(new BigInteger(k+"")) + ""));
    }


    static BigInteger factorial(BigInteger k) {
        if (k.equals(0)) return BigInteger.ONE;
        if (k.equals(1)) return BigInteger.ONE;
        BigInteger result = BigInteger.ONE;
        while (k.compareTo(BigInteger.ONE) >= 1) {
            result = result.multiply(k);
            k = k.subtract(BigInteger.ONE);
        }
        return result;
    }

    //done
}
