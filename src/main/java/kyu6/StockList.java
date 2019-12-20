package kyu6;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Behzod on 18, December, 2019
 */
public class StockList {
    public static void main(String[] args) {
        System.out.println(stockSummary(new String[]{"ABAR 200", "CDXE 500", "BKWR 250", "BTSQ 890", "DRTY 600"}, new String[] {"A", "B"}));
        System.out.println(stockSummary(new String[]{"ABART 20", "CDXEF 50", "BKWRK 25", "BTSQZ 89", "DRTYM 60"}, new String[] {"A", "B", "C", "W"}));
    }

    // 1st parameter is the stocklist (L in example),
    // 2nd parameter is list of categories (M in example)
    public static String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        if (lstOfArt.length == 0 || lstOf1stLetter.length == 0){
            return "";
        }
        long[] numbers = new long[lstOf1stLetter.length];
        for (int i = 0; i < lstOfArt.length; i++) {
            String[] art = lstOfArt[i].split(" ");
            String pos = art[0];
            String number = art[1];
            for (int j = 0; j < lstOf1stLetter.length; j++) {
                if (lstOf1stLetter[j].charAt(0) == pos.charAt(0)) {
                    numbers[j] += Long.parseLong(number);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lstOf1stLetter.length; i++) {
            sb.append("(" + lstOf1stLetter[i] + " : " + numbers[i] + ")");
            if (i < lstOf1stLetter.length - 1) sb.append(" - ");
        }
        return sb.toString();
    }

    public static String stockSummary1(String[] arts, String[] cats) {
        if (arts.length == 0) return "";
        final int space = arts[0].indexOf(" ");
        return Stream.of(cats)
                .map(c -> c + " : " + Stream.of(arts)
                        .filter(a -> c.contentEquals(a.subSequence(0, 1)))
                        .map(a -> a.substring(space + 1))
                        .mapToInt(Integer::parseInt)
                        .sum())
                .map(s -> "(" + s + ")")
                .collect(Collectors.joining(" - "));
    }
}
