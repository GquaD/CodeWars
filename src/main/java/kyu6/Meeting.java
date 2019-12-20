package kyu6;

import com.sun.media.jfxmediaimpl.platform.gstreamer.GSTPlatform;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Behzod on 19, December, 2019
 */
public class Meeting {

    public static void main(String[] args) {
        System.out.println(meeting("Alexis:Wahl;John:Bell;Victoria:Schwarz;Abba:Dorny;Grace:Meta;Ann:Arno;Madison:STAN;Alex:Cornwell;Lewis:Kern;Megan:Stan;Alex:Korn"));
        System.out.println(meeting("Fred:Corwill;Wilfred:Corwill;Barney:Tornbull;Betty:Tornbull;Bjon:Tornbull;Raphael:Corwill;Alfred:Corwill"));
        System.out.println(meeting("John:Gates;Michael:Wahl;Megan:Bell;Paul:Dorries;James:Dorny;Lewis:Steve;Alex:Meta;Elizabeth:Russel;Anna:Korn;Ann:Kern;Amber:Cornwell"));
        System.out.println(meeting("Alex:Arno;Alissa:Cornwell;Sarah:Bell;Andrew:Dorries;Ann:Kern;Haley:Arno;Paul:Dorny;Madison:Kern"));
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

    static String meeting(String s) {
        if (s.length() == 0) return "";
        String colon = ":";
        String[] values = s.split(";");
        ArrayList<String> surnames = new ArrayList<>();
        Map<String, ArrayList<String>> map = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            String[] fullName = values[i].split(":");
            String name = fullName[0].toLowerCase();
            String surname = fullName[1].toLowerCase();
            if (map.containsKey(surname)) {
                ArrayList<String> names = map.get(surname);
                names.add(name);
                map.put(surname, names);
            } else {
                ArrayList<String> names = new ArrayList<>();
                names.add(name);
                map.put(surname, names);
                surnames.add(surname);
            }
        }
        Collections.sort(surnames);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < surnames.size(); i++) {
            ArrayList<String> namesTemp = map.get(surnames.get(i));
            Collections.sort(namesTemp);
            for (int j = 0; j < namesTemp.size(); j++) {
                sb.append("(" + surnames.get(i).toUpperCase() + ", " + namesTemp.get(j).toUpperCase() + ")");
            }
        }
        return sb.toString();
    }

}
