import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class WeightForWeight {
    public static String countWeight(String str) {
        String[] array = str.split(" ");
        Arrays.sort(array);
        int[] weights = new int[array.length];

        //finding weights of each number
        for (int i = 0; i < array.length; i++) {
            int temp = 0;
            for (int j = 0; j < array[i].length(); j++) {
                temp += Integer.parseInt(array[i].charAt(j) + "");
            }
            weights[i] = temp;
        }
        //put into map where number is key and weight is value
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], weights[i]);
        }
        TreeMap<String, Integer> treeMap = new TreeMap<>(map);
        for (Map.Entry<String, Integer> entry: treeMap.entrySet()){
            System.out.println(entry.getKey());
        }
        int unique = map.size();




        String[] resultArray = new String[array.length];

       /* for (Map.Entry<String, Integer> entry: map.entrySet()){
            int i = 0;
            resultArray[i] = String.valueOf(entry.getValue().equals(weights[i]));
            i++;
        }*/

        String result = "";
        for (int i = 0; i < array.length; i++) {
            result += resultArray[i] + " ";
        }
        return result.trim();
    }


    public static String countWeight1(String str) {
        return str;
    }



    public static void main(String[] args) {
        System.out.println(countWeight("2000 10003 1234000 44444444 9999 11 11 22 123"));
        System.out.println(countWeight("56 65 74 100 99 68 86 180 90"));
        System.out.println(countWeight("180 10 14"));
        System.out.println(countWeight("103 123 4444 99 2000"));
    }
}
