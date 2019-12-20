import java.util.Arrays;

public class PangramChecker {
    public static boolean Check(String str) { 
        char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
       str.replaceAll("[^a-zA-Z]+", "");
       char[] temp = str.toLowerCase().toCharArray();
       Arrays.sort(temp);
        for (int i = 0; i < 26; i++) {
           int check = Arrays.binarySearch(temp, alphabet[i]);
           if (check < 0){
               return false;
           }
        }
        return true;
        // return string.replaceAll("[^a-zA-Z]+", "").matches("[a-zA-Z]+") ? true : false;

    }

    public boolean check1(String sentence){
        for (char c = 'a'; c<='z'; c++)
            if (!sentence.toLowerCase().contains("" + c))
                return false;
        return true;

    }

    public boolean check2(String sentence){
        return sentence.chars().map(Character::toLowerCase).filter(Character::isAlphabetic).distinct().count() == 26;
    }
}
