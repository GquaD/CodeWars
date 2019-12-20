public class CreatePhoneNumber {
    public static String createPhoneNumber(int[] numbers) {
        // Your code here!
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            if (i == 0) {
                result.append("(");
            }
            if (i <= 2) {
                result.append(numbers[i]);
            }
            if (i == 2) {
                result.append(") ");
            }
            if (i > 2 && i <= 5){
                result.append(numbers[i]);
            }
            if (i == 5) {
                result.append("-");
            }
            if (i > 5) {
                result.append(numbers[i]);
            }
        }
        return result.toString();
    }

    public static String createPhoneNumber1(int[] numbers) {
        return String.format("(%d%d%d) %d%d%d-%d%d%d%d",numbers[0],numbers[1],numbers[2],numbers[3],numbers[4],numbers[5],numbers[6],numbers[7],numbers[8],numbers[9]);
    }
}
