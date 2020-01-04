package kyu6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Behzod on 27, December, 2019
 */
public class BackspacesInString {
    public static void main(String[] args) {
        System.out.println(cleanString("abc#d##c"));
        System.out.println(cleanString("abc##d######"));
        System.out.println(cleanString("831cas/*-56+yq#w87h#fklsd-=-28f"));
        System.out.println("///////");
    }


    //works!
    public static String cleanString(String s) {
        Pattern p = Pattern.compile("[^#][#]");
        Matcher m = p.matcher(s);
        while (m.find()) {
            s = s.replaceAll("[^#][#]", "");
            m = p.matcher(s);
        }
        if (s.contains("#")) s = s.replaceAll("#", "");
        return s;
    }

}
