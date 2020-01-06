package kyu3;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/**
 * Created by Behzod on 18, December, 2019
 */
public class TheMillionthFibonacciKata {
    //NOT solved yet
    public static void main(String[] args) {
        System.out.println(fib(BigInteger.valueOf(0)));
        System.out.println(fib(BigInteger.valueOf(1)));
        System.out.println(fib(BigInteger.valueOf(2)));
        System.out.println(fib(BigInteger.valueOf(3)));
        System.out.println(fib(BigInteger.valueOf(4)));
        System.out.println(fib(BigInteger.valueOf(5)));
        System.out.println(fib(BigInteger.valueOf(10)));
        //System.out.println(fib(BigInteger.valueOf(1000)));
        System.out.println("///////////////////////////");
        System.out.println(fibon(0));
        System.out.println(fibon(1));
        System.out.println(fibon(2));
        System.out.println(fibon(3));
        System.out.println(fibon(4));
        System.out.println(fibon(5));
        System.out.println(fibon(10));
        System.out.println("///////////////////////////");
        System.out.println(fibo(BigInteger.valueOf(0)));
        System.out.println(fibo(BigInteger.valueOf(1)));
        System.out.println(fibo(BigInteger.valueOf(2)));
        System.out.println(fibo(BigInteger.valueOf(3)));
        System.out.println(fibo(BigInteger.valueOf(4)));
        System.out.println(fibo(BigInteger.valueOf(5)));
        System.out.println(fibo(BigInteger.valueOf(10)));
//        System.out.println(fibo(BigInteger.valueOf(-1)));
//        System.out.println(fibo(BigInteger.valueOf(-5)));
//        System.out.println(fibo(BigInteger.valueOf(-6)));
        System.out.println(fibo(BigInteger.valueOf(2000000)));
    }

    public static BigInteger fib(BigInteger n) {
        if (n.equals(BigInteger.valueOf(0))) {
            return BigInteger.ZERO;
        }
        if (n.equals(BigInteger.valueOf(1))) {
            return BigInteger.ONE;
        }
        return fib(n.subtract(BigInteger.valueOf(1))).add(fib(n.subtract(BigInteger.valueOf(2))));
    }

    public static double fibon(int n) {
        //формула Бине
        if (n == 0) return 0;
        if (n == 1) return 1;
        double goldenRatioPos = (1 + Math.sqrt(5)) / 2;
        double goldenRatioNeg = (1 - Math.sqrt(5)) / 2;
        double sqrtOf5 = Math.sqrt(5);
        double po = Math.pow(goldenRatioPos, n);
        double ne = Math.pow(goldenRatioNeg, n);
        return Math.round((po + ne) / sqrtOf5);
    }

    public static BigInteger fibo(BigInteger n) {
        //формула Бине
        int num = n.intValue();
        if (n.equals(BigInteger.ZERO)) {
            return new BigInteger(String.valueOf(0));
        }
        if (n.equals(BigInteger.ONE)) {
            return new BigInteger(String.valueOf(1));
        }
        BigDecimal bigDecimal = new BigDecimal("5");
        double goldenRatioPos = (1 + Math.sqrt(5)) / 2;
        double goldenRatioNeg = (1 - Math.sqrt(5)) / 2;
        double sqrtOf5 = Math.sqrt(5);
        BigDecimal pos = new BigDecimal(goldenRatioPos);
        BigDecimal neg = new BigDecimal(goldenRatioNeg);
        pos = pos.pow(n.intValue()); //takes too much time
        neg = neg.pow(n.intValue());
        //neg = new BigDecimal(String.valueOf(Math.round(Math.pow(goldenRatioNeg, n.intValue()))));
        BigDecimal sum = pos.add(neg);
        BigDecimal result = sum.divide(BigDecimal.valueOf(sqrtOf5), RoundingMode.HALF_UP);
        //result = result.setScale(0, RoundingMode.HALF_UP);

        if (n.compareTo(new BigInteger(String.valueOf(0))) < 0){
            int coef = n.intValue();
            coef = (int) Math.pow(-1, coef);
            result = result.multiply(new BigDecimal(String.valueOf(coef)));
        }

        return result.toBigInteger();
    }

   /* public static BigDecimal sqrt(BigDecimal A, final int SCALE) {
        BigDecimal x0 = new BigDecimal("0");
        BigDecimal x1 = new BigDecimal(Math.sqrt(A.doubleValue()));
        while (!x0.equals(x1)) {
            x0 = x1;
            x1 = A.divide(x0, SCALE, ROUND_HALF_UP);
            x1 = x1.add(x0);
            x1 = x1.divide(TWO, SCALE, ROUND_HALF_UP);

        }
        return x1;
    }*/
}
