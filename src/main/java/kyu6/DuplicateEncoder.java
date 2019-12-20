package kyu6;

/**
 * Created by Behzod on 16, December, 2019
 */
public class DuplicateEncoder {
    public static void main(String[] args) {
        System.out.println(encode("din"));
        System.out.println(encode("recede"));
        System.out.println(encode("Success"));
        System.out.println(encode("(( @"));
        System.out.println(encode("Prespecialized"));
        System.out.println(encode("   ()(   "));
        System.out.println(encode("\\avdse"));
        System.out.println(encode("\\avdse\\"));
        System.out.println(encode("\\\\avdse"));
    }

    static String encode(String str) {
        String result = "";
        String str2 = str.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            String temp = "";
            //System.out.println(str.charAt(i) + "");
            if ((str.charAt(i) + "").matches("[a-zA-Z0-9]")) {
                temp = str2.replaceFirst(str.charAt(i) + "", "");
            } else if ((str.charAt(i) + "").equals("\\")) {
                temp = str.replaceFirst("\\\\", "");
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("\\").append(str.charAt(i) + "");
                temp = str.replaceFirst(sb.toString(), "");
            }
            if (temp.contains(Character.toString(str2.charAt(i))) && (str.charAt(i) + "").matches("[a-zA-Z]")) {
                result += ")";
            } else if (temp.contains(Character.toString(str.charAt(i)))) {
                result += ")";
            } else {
                result += "(";
            }
        }
        return result;
    }
}
