public class FindMissingLetter {
    char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public static char findMissingLetter(char[] array) {
        char result = 'a';
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] + 1 != array[i + 1]) {
                result = (char) (array[i] + 1);
            }
        }
        return result;
    }
}
