package kyu6;

/**
 * Created by Behzod on 18, December, 2019
 */
public class FindTheInBetweenPoint {
    public static void main(String[] args) {
        System.out.println(middle_point(1, 2, 3, 4, 5, 6, 7, 8, 9));
        System.out.println(middle_point(0, 2, 0, 6, -2, 8, 3, 0, 4));
        System.out.println(middle_point(1, 0, 4, 5, 0, 6, -3, 0, 2));
        System.out.println(middle_point(-1, 0, 2, -2, 4, -1, -3, 8, -4));

        /*assertEquals("", 2, Points_On_A_Line.middle_point(1,2,3, 4,5,6, 7,8,9)  );
        assertEquals("", 3, Points_On_A_Line.middle_point(0,2,0, 6,-2,8, 3,0,4) );
        assertEquals("", 1, Points_On_A_Line.middle_point(1,0,4, 5,0,6, -3,0,2) );
        assertEquals("", 2, Points_On_A_Line.middle_point(-1,0,2, -2,4,-1, -3,8,-4) );*/
    }

    public static int middle_point(double x1, double y1, double z1,
                                   double x2, double y2, double z2,
                                   double x3, double y3, double z3) {
        double a = Math.abs(x1) + Math.abs(y1) + Math.abs(z1);
        double b = Math.abs(x2) + Math.abs(y2) + Math.abs(z2);
        double c = Math.abs(x3) + Math.abs(y3) + Math.abs(z3);
        if ((a > b && b > c) || (c > b && b > a)) {
            return 2;
        } else if ((a > c && c > b) || (b > c && c > a)) {
            return 3;
        } else if ((b > a && a > c) || (c > a && a > b)) {
            return 1;
        } else if (a > b && c > b) {
            if (a > c) return 3;
            else return 1;
        } else if (b > a && c > a) {
            if (b > c) return 3;
            else return 2;
        } else if (a > c && b > c) {
            if (a > b) return 2;
            else return 1;
        }
        return 1;
    }
}
