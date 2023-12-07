package src.programmers.highscorekit.hash;

import java.util.HashMap;
import java.util.Map;

public class 완주하지못한선수 {
    class Solution {
        public static String solution(String[] participant, String[] completion) {
            Map<String, Integer> map = new HashMap<>();

            // 참여자 명단을 해시 맵에 등록
            for (String participantName : participant) {
                map.put(participantName, map.getOrDefault(participantName, 0) + 1);
            }

            // 완주자 명단을 해시 맵에서 차감
            for (String completionName : completion) {
                map.put(completionName, map.get(completionName) - 1);
            }

            // 해시 맵에서 값이 1인 선수를 찾아 반환
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() == 1) {
                    return entry.getKey();
                }
            }

            return null; // 예외 처리, 실제로는 발생하지 않음
        }
    }
}
