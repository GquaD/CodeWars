public class GetXO {

    public static boolean getXO (String str) {
        String check = str.toLowerCase();
        int countX = 0, countO = 0;
        for (int i = 0; i < check.length(); i++) {
            if (check.charAt(i) == 'x'){
                countX++;
            } else if (check.charAt(i) == 'o'){
                countO++;
            }
        }
        if (countO == countX) {
            return true;
        } else {
            return false;
        }
    }
}
