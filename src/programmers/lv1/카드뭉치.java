package programmers.lv1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class 카드뭉치 {

    class Solution {
        public String solution(String[] cards1, String[] cards2, String[] goal) {
            String answer = "Yes";

            Map<String, Integer> cards1Map = new HashMap<>();
            for (int i = 0; i < cards1.length; i++) {
                cards1Map.put(cards1[i], i);
            }

            Map<String, Integer> cards2Map = new HashMap<>();
            for (int i = 0; i < cards2.length; i++) {
                cards2Map.put(cards2[i], i);
            }

            int cards1Index = 0;
            int cards2Index = 0;

            for (int i = 0; i < goal.length; i++) {
                if (cards1Index < cards1.length && cards1Map.get(goal[i]).equals(cards1Index)) {
                    cards1Index++;
                } else if (cards2Index < cards2.length && cards2Map.get(goal[i]).equals(cards2Index)) {
                    cards2Index++;
                } else {
                    answer = "No";
                    break;
                }
            }
            return answer;
        }
    }

    class Solution2 {
        public String solution(String[] cards1, String[] cards2, String[] goal) {
            String answer = "Yes";

            int card1Index = 0;
            int card2Index = 0;

            for (int i = 0; i < goal.length; i++) {
                if(card1Index < cards1.length && goal[i].equals(cards1[card1Index])) {
                    card1Index++;
                    continue;
                }

                if(card2Index < cards2.length && goal[i].equals(cards2[card2Index])) {
                    card2Index++;
                    continue;
                }

                answer = "No";
                return answer;
            }

            return answer;
        }
    }

}
