import java.util.Arrays;

public class Wave {
    public static String[] wave(String str) {
        String newStr = str.replaceAll(" ", "");
        String[] result = new String[newStr.length()];
        String upper = newStr.toUpperCase();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < newStr.length() ; i++) {
            //if ((str.charAt(i) + "").equals(" ")) continue;
            result[i] = sb.append(newStr).replace(i, i + 1, (upper.charAt(i) + "")).toString().trim();
            sb.setLength(0);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(wave("hello")));
        System.out.println(Arrays.toString(wave("codewars")));
        System.out.println(Arrays.toString(wave("")));
        System.out.println(Arrays.toString(wave("two words")));
        System.out.println(Arrays.toString(wave(" gap ")));
    }
}
