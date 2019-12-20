public class Square {
    public static boolean isSquare(int n) {
        double sqrt = Math.sqrt(n);
        int intSqrt = (int) sqrt;
        if (sqrt > intSqrt || n < 0) {
            return false;
        } else return true; // fix me!
    }

    public static boolean isSquare1(int n) {
        return Math.sqrt(n) % 1 == 0;
    }
}
