package kyu7;

/**
 * Created by Behzod on 24, December, 2019
 */
public class ComplementaryDNA {
    public static void main(String[] args) {
        System.out.println(makeComplement("ATTA"));
        System.out.println(makeComplement("ATTGC"));
        System.out.println(makeComplement("GTAT"));
        System.out.println(makeComplement("TTTT"));
    }

    static String makeComplement(String s){
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') result += "T";
            if (s.charAt(i) == 'T') result += "A";
            if (s.charAt(i) == 'C') result += "G";
            if (s.charAt(i) == 'G') result += "C";
        }
        return result;
    }

}
