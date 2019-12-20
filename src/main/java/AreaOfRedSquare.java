public class AreaOfRedSquare {
    public static double squareArea(double A){

        return Math.round(((4 * A * A * 100)/ (Math.PI * Math.PI))) / 100.0;
    }
}
