package src.programmers.lv1;

public class 이상한문자만들기 {
    class Solution {
        public String solution(String s) {
            String[] s1 = s.split(" ");
            StringBuilder answer = new StringBuilder();

            for (String s2 : s1) {
                for (int i = 0; i < s2.length(); i++) {
                    if (i % 2 == 0) {
                        answer.append(Character.toUpperCase(s2.charAt(i)));
                    } else {
                        answer.append(Character.toLowerCase(s2.charAt(i)));
                    }
                }
                answer.append(" ");
            }

            answer.deleteCharAt(answer.length() - 1);

            return answer.toString();
        }
    }

    class Solution2 {
        public String solution(String s) {

            String answer = "";
            int cnt = 0;
            String[] array = s.split("");

            for(String ss : array) {
                cnt = ss.contains(" ") ? 0 : cnt + 1;
                answer += cnt%2 == 0 ? ss.toLowerCase() : ss.toUpperCase();
            }
            return answer;
        }
    }
}
