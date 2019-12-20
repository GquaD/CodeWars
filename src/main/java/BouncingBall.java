import jdk.nashorn.internal.ir.SwitchNode;

import java.text.DecimalFormat;

public class BouncingBall {
    public static int passNumber(double height, double bounceCoef, double window) {
        if (height < 0 || bounceCoef < 0 || bounceCoef >= 1 || window > height || height == window) {
            return -1;
        } else {
            return 2 + passNumber(height * bounceCoef, bounceCoef, window);
        }


    }

    static int countBounces (double height, double bounceCoef, double windowHeight) {
        return (height < 0 || bounceCoef < 0 || bounceCoef >= 1 || windowHeight > height) ? -1 : 2 + countBounces(height * bounceCoef, bounceCoef, windowHeight);
    }

    public static int passNumber1(double height, double bounceCoef, double window) {
         DecimalFormat df2 = new DecimalFormat("#.##");
        if (height < 0 || bounceCoef < 0 || bounceCoef >= 1 || window > height) {
            return -1;
        } else {
           double tempHeight = 0.0;
           int count = 0;
           if (height > window) {
               count++;
           }
           while ((tempHeight = Double.parseDouble(df2.format(height * bounceCoef))) > window) {
               count += 2;
           }
           if (tempHeight == window) {
               count++;
           }
            return count;
        }
    }

    public static void main(String[] args) {
        System.out.println(passNumber(3, 0.66, 1.5));
        System.out.println(passNumber(30, 0.66, 1.5));
        System.out.println(passNumber(3, 0.66, 1.5));
        System.out.println(passNumber(30.0, 0.66, 1.5));
        System.out.println(passNumber(30, 1, 1.5));
//        System.out.println(countBounces(3, 1, 1.5));
//        System.out.println(countBounces(3, 1, 1.5));


    }
}
