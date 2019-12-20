import com.sun.javafx.binding.StringFormatter;
import com.sun.xml.internal.ws.util.StringUtils;

public class Maskify {
    public static String maskify(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (str.length() > 4) {
            for (int i = 0; i < str.length() - 4; i++) {
                sb.replace(i, i + 1, "#");
                //str.replace(str.charAt(i), '#');
            }
        }
        return sb.toString();
        //return str.length() > 4 ? str.replaceAll(".", "#") : str;
        // return str.length() > 4 ? (new StringBuilder(str.length() - 4).toString().replaceAll(".", "#")).toString() : str;
        //return str.length() > 4 ? new StringBuilder(str.length()).replace(0, str.length() - 5, "#").toString() : str;
        // return new StringBuilder(str.length()).replace(0, str.length() - 5, "#").toString();
        // return String.format("%0" + str.length() + "s", str);
    }

    public static String maskify1(String str) {
        return str.replaceAll(".(?=.{4})", "#");
    }
}
