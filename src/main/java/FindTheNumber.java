import java.util.Arrays;

public class FindTheNumber {
    public static double findUniq(double arr[]) {
        Arrays.sort(arr);
        return arr[0] != arr[1] ? arr[0] : arr[arr.length - 1];
        /*if (arr[0] != arr[1]) {
            return arr[0];
        } else return arr[arr.length - 1];*/
    }
}
