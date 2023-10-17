package src.programmers.lv1;

import java.util.Stack;

public class 신규아이디추천 {
    class Solution {
        public String solution(String new_id) {
            String answer = new_id;
            answer = answer.toLowerCase();
            answer = answer.replaceAll("[^a-z0-9-_.]", "");
            answer = answer.replaceAll("[.]{2,}", ".");
            answer = answer.replaceAll("^[.]|[.]$", "");
            if (answer.equals("")) {
                answer += "a";
            }
            if (answer.length() >= 16) {
                answer = answer.substring(0, 15);
                answer = answer.replaceAll("[.]$", "");
            }
            if (answer.length() <= 2) {
                while (answer.length() < 3) {
                    answer += answer.charAt(answer.length() - 1);
                }
            }

            return answer;
        }
    }

    /*
    정규식을 사용한 풀이
    * */
}
