import java.util.HashMap;
import java.util.Map;

public class TenMinuteWalk {
    public static boolean takeWalk(char[] walk){
        int[] occurences = new int[4];
        for (int i = 0; i < walk.length; i++) {
            if (walk[i] == 'n') {
               occurences[0]++;
            }
            if (walk[i] == 's') {
               occurences[1]++;
            }
            if (walk[i] == 'e') {
               occurences[2]++;
            }
            if (walk[i] == 'w') {
               occurences[3]++;
            }
        }
        if (walk.length == 10 && occurences[0] == occurences[1] & occurences[2] == occurences[3]){
            return true;
        } else return false;
    }

    public static void main(String[] args) {
        System.out.println(takeWalk(new char[] {'n','s','n','s','n','s','n','s','n','s'}));
        System.out.println(takeWalk(new char[] {'w','e','w','e','w','e','w','e','w','e','w','e'}));
        System.out.println(takeWalk(new char[] {'w'}));
        System.out.println(takeWalk(new char[] {'n','n','n','s','n','s','n','s','n','s'}));
    }
}
