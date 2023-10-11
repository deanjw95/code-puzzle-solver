package src.programmers.lv1;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class 성격유형검사하기 {

    class Solution {
        public String solution(String[] survey, int[] choices) {
            StringBuilder answer = new StringBuilder();
            Map<Character, Integer> map = new HashMap<>();
            map.put('R', 0);
            map.put('T', 0);
            map.put('C', 0);
            map.put('F', 0);
            map.put('J', 0);
            map.put('M', 0);
            map.put('A', 0);
            map.put('N', 0);

            for (int i = 0; i < survey.length; i++) {
                String s = survey[i];
                int choice = choices[i];

                Character c = 'a';
                if (choice > 4) {
                    c = s.charAt(1);
                } else if (choice == 4) {
                    continue;
                } else {
                    c = s.charAt(0);
                }

                map.put(c, map.get(c) + Math.abs(choice - 4));
            }

            answer.append(map.get('R') >= map.get('T') ? 'R' : 'T');
            answer.append(map.get('C') >= map.get('F') ? 'C' : 'F');
            answer.append(map.get('J') >= map.get('M') ? 'J' : 'M');
            answer.append(map.get('A') >= map.get('N') ? 'A' : 'N');

            return answer.toString();
        }
    }

}
