package other;

import java.util.HashMap;


/**
 * Created by  on 08, December, 2019
 */
public class Morse {
    static String textLatin = "Hello my name is Ololosh and this is Morse";
    static String id = "15789856";
    static String textMorse = ".... .!.-.. .-.. ---";


    static HashMap<String, String> getDicitionaryToMorse() {
        HashMap<String, String> dictionary = new HashMap<>();
        dictionary.put("A", ".-");
        dictionary.put("B", "-...");
        dictionary.put("C", "-.-.");
        dictionary.put("D", "-..");
        dictionary.put("E", ".");
        dictionary.put("F", "..-.");
        dictionary.put("G", "--.");
        dictionary.put("H", "....");
        dictionary.put("I", "..");
        dictionary.put("J", ".---");
        dictionary.put("K", "-.-");
        dictionary.put("L", ".-..");
        dictionary.put("M", "--");
        dictionary.put("N", "-.");
        dictionary.put("O", "---");
        dictionary.put("P", ".--.");
        dictionary.put("Q", "--.-");
        dictionary.put("R", ".-.");
        dictionary.put("S", "...");
        dictionary.put("T", "-");
        dictionary.put("U", "..-");
        dictionary.put("V", "...-");
        dictionary.put("W", ".--");
        dictionary.put("X", "-..-");
        dictionary.put("Y", "-.--");
        dictionary.put("Z", "--..");
        return dictionary;
    }

    static HashMap<String, String> getDicitionaryFromMorseToLatin() {
        HashMap<String, String> dictionary = new HashMap<>();
        dictionary.put(".-", "A");
        dictionary.put("-...", "B");
        dictionary.put("-.-.", "C");
        dictionary.put("-..", "D");
        dictionary.put(".", "E");
        dictionary.put("..-.", "F");
        dictionary.put("--.", "G");
        dictionary.put("....", "H");
        dictionary.put("..", "I");
        dictionary.put(".---", "J");
        dictionary.put("-.-", "K");
        dictionary.put(".-..", "L");
        dictionary.put("--", "M");
        dictionary.put("-.", "N");
        dictionary.put("---", "O");
        dictionary.put(".--.", "P");
        dictionary.put("--.-", "Q");
        dictionary.put(".-.", "R");
        dictionary.put("...", "S");
        dictionary.put("-", "T");
        dictionary.put("..-", "U");
        dictionary.put("...-", "V");
        dictionary.put(".--", "W");
        dictionary.put("-..-", "X");
        dictionary.put("-.--", "Y");
        dictionary.put("--..", "Z");
        return dictionary;
    }

    public static void main(String[] args) {
        //counting number of words needed to translate from Latin to Morse
        int numberOfWords = countWordsToTranslate(takeLastThreeDigits(id));
        System.out.println(latinToMorse(numberOfWords, textLatin));
        System.out.println();
        System.out.println(morseToLatin(numberOfWords, textMorse));
    }

    static int takeLastThreeDigits(String id) {
        String number = id.substring(id.length() - 3);
        Integer myInt = Integer.parseInt(number);
        return myInt;
    }

    static int countWordsToTranslate(int num) {
        int result = num / 100 + (num % 100) / 10 + (num % 100) % 10;

        if (result >= 10) {
            result = result / 10 + result % 10;
        }

        if (result >= 10) {
            result = result / 10 + result % 10;
        }

        return result;
    }

    static String latinToMorse(int num, String text) {
        HashMap<String, String> dictionary = getDicitionaryToMorse();
        String result = "";
        String[] words = text.split(" ");

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                String letter = Character.toString(words[i].charAt(j)).toUpperCase();
                result += dictionary.get(letter) + " ";
            }
        }
        return result.trim();
    }

    static String morseToLatin(int num, String text) {
        HashMap<String, String> dictionary = getDicitionaryFromMorseToLatin();
        String result = "";
        String[] wordsInMorse = text.split("!");
        for (int i = 0; i < num; i++) {
            String[] lettersInMorse = wordsInMorse[i].split(" ");
            for (int j = 0; j < lettersInMorse.length; j++) {
                result += dictionary.get(lettersInMorse[j]);
            }
            result += " ";
        }
        return result.trim();
/*
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < wordsInMorse[i].length(); j++) {
                String letter = Character.toString(wordsInMorse[i].charAt(j));
                result += dictionary.get(letter);
            }
            result += " ";
        }
        return result.trim();*/
    }
}
