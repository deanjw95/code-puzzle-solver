package src.programmers.lv1;

public class 시저암호 {
    class Solution {
        public String solution(String s, int n) {
            StringBuilder answer = new StringBuilder();
            int a = 'a';
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ' ') {
                    answer.append(' ');
                    continue;
                }
                int c = s.charAt(i);
                if (c >= 'a' && c <= 'z') {
                    c += n;
                    if (c > 'z') {
                        c -= 26;
                    }
                } else if (c >= 'A' && c <= 'Z') {
                    c += n;
                    if (c > 'Z') {
                        c -= 26;
                    }
                }

                answer.append((char) c);
            }

            return answer.toString();
        }
    }

    class Caesar {
        String caesar(String s, int n) {
            String result = "";
            n = n % 26;
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (Character.isLowerCase(ch)) {
                    ch = (char) ((ch - 'a' + n) % 26 + 'a');
                } else if (Character.isUpperCase(ch)) {
                    ch = (char) ((ch - 'A' + n) % 26 + 'A');
                }
                result += ch;
            }
            return result;
        }
    }
}
