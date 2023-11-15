package src.programmers.lv1;

public class 문자열다루기기본 {
    class Solution {
        public boolean solution(String s) {
            boolean answer = true;

            if (s.length() == 4 || s.length() == 6) {
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                        answer = false;
                        break;
                    }
                }
            } else {
                answer = false;
            }

            return answer;
        }
    }

    class Solution2 {
        public boolean solution(String s) {
            if (s.length() == 4 || s.length() == 6) return s.matches("(^[0-9]*$)");
            return false;
        }
    }
}
