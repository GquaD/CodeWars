import java.util.Arrays;
import java.util.Comparator;

public class OrderOfWords {
    public static String order(String words) {
        String[] temp = words.split(" ");
        String[] result = new String[temp.length];
        int[] numbers = new int[temp.length];
        StringBuilder resultString = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (temp[j].contains(numbers[i] + "")) {
                    if (i == numbers.length - 1) {
                        result[i] = temp[j];
                    } else {
                        result[i] = temp[j] + " ";
                    }
                }
            }
        }

        for (int i = 0; i < result.length; i++) {
            if (result[i] != null) {
                resultString.append(result[i]);
            } else {
                resultString.append("");
            }
        }

        return resultString.toString();
    }

    public static String order1(String words) {
        return Arrays.stream(words.split(" "))
                .sorted(Comparator.comparing(s -> Integer.valueOf(s.replaceAll("\\D", ""))))
                .reduce((a, b) -> a + " " + b).get();
    }
}
