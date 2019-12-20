package kyu5;

/**
 * Created by Behzod on 12, December, 2019
 */
public class SimplePigLatin {

    public static void main(String[] args) {
        System.out.println(pigIt("Pig latin is cool"));
        System.out.println(pigIt("Hello world !"));
    }

    static String pigIt(String text) {
        //need to consider cases with punctuations, e.g. commas
        StringBuilder sb = new StringBuilder();
        String[] words = text.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].matches("^[a-zA-z]*$")) {
                words[i] = composeWord(words[i]);
                sb.append(words[i] + " ");
            } else {
                sb.append(words[i] + " ");
            }

        }
        return sb.toString().trim();
    }

    static String composeWord(String word) {
        StringBuilder sb = new StringBuilder();
        sb.append(word.substring(1));
        sb.append(word.charAt(0));
        sb.append("ay");
        return sb.toString();
    }
}
