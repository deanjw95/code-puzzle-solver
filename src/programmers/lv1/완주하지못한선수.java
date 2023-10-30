package src.programmers.lv1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 완주하지못한선수 {
    class Solution {
        public String solution(String[] participant, String[] completion) {
            Arrays.sort(participant);
            Arrays.sort(completion);

            for (int i = 0; i < completion.length; i++) {
                if (!completion[i].equals(participant[i])) {
                    return participant[i];
                }
            }

            return participant[participant.length - 1];
        }
    }

    class Solution2 {
        public String solution(String[] participant, String[] completion) {
            String answer = "";
            HashMap<String, Integer> hm = new HashMap<>();
            for (String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1);
            for (String player : completion) hm.put(player, hm.get(player) - 1);

            for (String key : hm.keySet()) {
                if (hm.get(key) != 0){
                    answer = key;
                }
            }
            return answer;
        }
    }
}
