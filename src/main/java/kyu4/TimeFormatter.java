package kyu4;

import java.util.Arrays;

/**
 * Created by Behzod on 12, December, 2019
 */

//done!
public class TimeFormatter {
    public static void main(String[] args) {
        System.out.println(formatDuration(31536000));
        System.out.println(formatDuration(31536001));
        System.out.println(formatDuration(31539600));
        System.out.println(formatDuration(31539601));
        System.out.println(formatDuration(42539601));
        System.out.println(formatDuration(42537621));
        System.out.println(formatDuration(42512421));
        System.out.println(formatDuration(10976421));
        System.out.println(formatDuration(0));
    }

    static String formatDuration(int amount) {
        long[] names = new long[5];
        String[] strings = {"second", "minute", "hour", "day", "year"};

        //years - 0, days - 1, hours - 2, minutes - 3, seconds - 4

        if (amount < 1) {
            return "now";
        }
        //seconds
        if (amount % 60 == 0) {
        } else if (amount % 60 == 1) {
            names[0] = 1;
        } else {
            names[0] = amount % 60;
        }
        amount /= 60;

        //minutes
        if (amount % 60 == 0) {
        } else if (amount % 60 == 1) {
            names[1] = 1;
        } else {
            names[1] = amount % 60;
        }
        amount /= 60;

        //hours
        if (amount % 24 == 0) {
        } else if (amount % 24 == 1) {
            names[2] = 1;
        } else {
            names[2] = amount % 24;
        }
        amount /= 24;

        //days
        if (amount % 365 == 0) {
        } else if (amount % 365 == 1) {
            names[3] = 1;
        } else {
            names[3] = amount % 365;
        }
        amount /= 365;

        //years
        if (amount > 0) {
            if (amount == 1) {
                names[4] = 1;
            } else {
                names[4] = amount;
            }
        }

        names = reversLong(names);
        strings = reversString(strings);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < names.length; i++) {
            if (names[i] == 0) continue;
            if (names[i] != 1) strings[i] += "s";
        }
        for (int i = 0; i < names.length; i++) {
            if (names[i] != 0) {
                sb.append(names[i] + " " + strings[i] + ", ");
            }
        }
        String text = sb.toString().trim();
        String[] strings1 = text.split(",");


        StringBuilder result = new StringBuilder();
        if (strings1.length == 1) {
            result.append(strings1[0].trim());
        } else if (strings1.length == 2) {
            result.append(strings1[0].trim());
            result.append(" and ");
            result.append(strings1[1].trim());
        } else {
            result.append(strings1[0]);
            for (int i = 1; i < strings1.length - 1; i++) {
                result.append("," + strings1[i]);
            }
            result.append(" and" + strings1[strings1.length - 1]);
        }
        return result.toString().trim();
    }

    static long[] reversLong(long[] array) {
        for(int i=0; i<array.length/2; i++){
            long temp = array[i];
            array[i] = array[array.length -i -1];
            array[array.length -i -1] = temp;
        }
        return array;
    }

    static String[] reversString(String[] array) {
        for(int i=0; i<array.length/2; i++){
            String temp = array[i];
            array[i] = array[array.length -i -1];
            array[array.length -i -1] = temp;
        }
        return array;
    }

}
