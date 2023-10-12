package src.programmers.lv1;

import java.util.Map;
import java.util.Stack;

public class 숫자문자열과영단어 {

    class Solution {
        public int solution(String s) {
            StringBuilder answer = new StringBuilder();
            StringBuilder sb = new StringBuilder();
            Map<String, Integer> map = Map.of(
                    "zero", 0,
                    "one", 1,
                    "two", 2,
                    "three", 3,
                    "four", 4,
                    "five", 5,
                    "six", 6,
                    "seven", 7,
                    "eight", 8,
                    "nine", 9
            );

            for (int i = 0; i < s.length(); i++) {
                if (Character.isDigit(s.charAt(i))) {
                    answer.append(s.charAt(i));
                } else {
                    sb.append(s.charAt(i));
                    if (map.containsKey(sb.toString())) {
                        answer.append(map.get(sb.toString()));
                        sb = new StringBuilder();
                    }
                }
            }
            return Integer.parseInt(answer.toString());
        }
    }

    class Solution2 {
        public int solution(String s) {
            String[] strArr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
            for(int i = 0; i < strArr.length; i++) {
                s = s.replaceAll(strArr[i], Integer.toString(i));
            }
            return Integer.parseInt(s);
        }
    }
}
