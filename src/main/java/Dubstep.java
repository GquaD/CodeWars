import java.util.Arrays;

public class Dubstep {
    public static String songDecoder(String song){
        String[] my = song.split("WUB");
        //return Arrays.toString(string.split("(.*)(WUB)(.*)"));
        String result = "";
        for (int i = 0; i < my.length; i++) {
            if (i == my.length - 1) {
                result += my[i];
                continue;
            }
            result += my[i] + " ";
        }
        return result.trim().replaceAll(" +", " ");
    }

    public static String songDecoder1(String song)
    {
        return song.replaceAll("(WUB)+", " ").trim();
    }

    public static void main(String[] args) {
        System.out.println(songDecoder("WUBWEWUBAREWUBWUBTHEWUBCHAMPIONSWUBMYWUBFRIENDWUB"));
        System.out.println(songDecoder("WUBWUBABCWUB"));
        System.out.println(songDecoder("RWUBWUBWUBLWUB"));

    }
}
