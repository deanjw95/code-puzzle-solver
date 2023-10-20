package src.programmers.lv1;

public class 핸드폰번호가리기 {
    class Solution {
        public String solution(String phone_number) {
            StringBuilder answer = new StringBuilder();
            for (int i = 0; i < phone_number.length(); i++) {
                if (i < phone_number.length() - 4) {
                    answer.append("*");
                } else {
                    answer.append(phone_number.charAt(i));
                }
            }
            return answer.toString();
        }
    }

    class Solution2 {
        public String solution(String phone_number) {
            char[] ch = phone_number.toCharArray();
            for(int i = 0; i < ch.length - 4; i ++){
                ch[i] = '*';
            }
            return String.valueOf(ch);
        }
    }
}
