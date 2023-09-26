package src.programmers.lv1;

public class 문자열나누기 {

    class Solution {
        public int solution(String s) {
            int answer = 0;

            char ch = s.charAt(0);
            int same = 0;
            int diff = 0;
            for (int i = 0; i < s.length(); i++) {
                if (ch == s.charAt(i)) {
                    same++;
                } else {
                    diff++;
                }
                if (same == diff) {
                    same = 0;
                    diff = 0;
                    answer++;
                    if (i + 1 < s.length()) {
                        ch = s.charAt(i + 1);
                    }
                }
            }
            if (same != 0) {
                answer++;
            }

            return answer;
        }
    }

    class Solution2 {

        public int solution(String s) {
            char prev = '1';
            int same = 0, different = 0, answer = 0;
            for (char c : s.toCharArray()) {
                if (prev == '1') {
                    prev = c;
                    same++;
                    answer++;
                } else if (prev == c) {
                    same++;
                } else {
                    different++;
                }

                if (same == different) {
                    prev = '1';
                    same = 0; different = 0;
                }
            }

            return answer;
        }
    }

}
