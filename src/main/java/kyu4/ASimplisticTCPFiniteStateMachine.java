package kyu4;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Behzod on 06, January, 2020
 */
public class ASimplisticTCPFiniteStateMachine {
    public static void main(String[] args) {
        System.out.println(traverseStates(new String[] {"APP_ACTIVE_OPEN","RCV_SYN_ACK","RCV_FIN"}));
        System.out.println(traverseStates(new String[] {"APP_PASSIVE_OPEN", "RCV_SYN","RCV_ACK"}));
        System.out.println(traverseStates(new String[] {"APP_ACTIVE_OPEN","RCV_SYN_ACK","RCV_FIN","APP_CLOSE"}));
        System.out.println(traverseStates(new String[] {"APP_ACTIVE_OPEN"}));
        System.out.println(traverseStates(new String[] {"APP_PASSIVE_OPEN","RCV_SYN","RCV_ACK","APP_CLOSE","APP_SEND"}));
        System.out.println("///////////////////");
        System.out.println(traverseStates(new String[] {"APP_PASSIVE_OPEN", "APP_SEND", "RCV_SYN_ACK"}));
        System.out.println(traverseStates(new String[] {"APP_ACTIVE_OPEN", "RCV_SYN_ACK", "APP_CLOSE", "RCV_FIN_ACK", "RCV_ACK"}));
    }

    public static String traverseStates(String[] events) {
        String state = "CLOSED";
        Map<String, String> tempMap = new HashMap<>();
        Map<String, Map<String, String>> mapTCP = generateMap();
        for (int i = 0; i < events.length; i++) {
            tempMap = mapTCP.get(state);
            if (tempMap == null || tempMap.size() < 1) {
                state = "ERROR";
                break;
            } else {
                state = tempMap.get(events[i]);
                if (state == null || state.isEmpty()) {
                    state = "ERROR";
                    break;
                }
            }
        }

        return state;
    }

    public static Map<String, Map<String, String>> generateMap() {
        Map<String, Map<String, String>> map = new HashMap<>();
        Map<String, String> innerMap = new HashMap<>();
        innerMap.put("APP_PASSIVE_OPEN", "LISTEN");
        innerMap.put("APP_ACTIVE_OPEN", "SYN_SENT");
        map.put("CLOSED", innerMap);
        innerMap = new HashMap<>();
        innerMap.put("RCV_SYN", "SYN_RCVD");
        innerMap.put("APP_SEND", "SYN_SENT");
        innerMap.put("APP_CLOSE", "CLOSED");
        map.put("LISTEN", innerMap);
        innerMap = new HashMap<>();
        innerMap.put("APP_CLOSE", "FIN_WAIT_1");
        innerMap.put("RCV_ACK", "ESTABLISHED");
        map.put("SYN_RCVD", innerMap);
        innerMap = new HashMap<>();
        innerMap.put("RCV_SYN", "SYN_RCVD");
        innerMap.put("RCV_SYN_ACK", "ESTABLISHED");
        innerMap.put("APP_CLOSE", "CLOSED");
        map.put("SYN_SENT", innerMap);
        innerMap = new HashMap<>();
        innerMap.put("APP_CLOSE", "FIN_WAIT_1");
        innerMap.put("RCV_FIN", "CLOSE_WAIT");
        map.put("ESTABLISHED", innerMap);
        innerMap = new HashMap<>();
        innerMap.put("RCV_FIN", "CLOSING");
        innerMap.put("RCV_FIN_ACK", "TIME_WAIT");
        innerMap.put("RCV_ACK", "FIN_WAIT_2");
        map.put("FIN_WAIT_1", innerMap);
        innerMap = new HashMap<>();
        innerMap.put("RCV_ACK", "TIME_WAIT");
        map.put("CLOSING", innerMap);
        innerMap = new HashMap<>();
        innerMap.put("RCV_FIN", "TIME_WAIT");
        map.put("FIN_WAIT_2", innerMap);
        innerMap = new HashMap<>();
        innerMap.put("APP_TIMEOUT", "CLOSED");
        map.put("TIME_WAIT", innerMap);
        innerMap = new HashMap<>();
        innerMap.put("APP_CLOSE", "LAST_ACK");
        map.put("CLOSE_WAIT", innerMap);
        innerMap = new HashMap<>();
        innerMap.put("RCV_ACK", "CLOSED");
        map.put("LAST_ACK", innerMap);
        innerMap = new HashMap<>();
        return map;
    }
}
