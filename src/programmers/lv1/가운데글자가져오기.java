package src.programmers.lv1;

public class 가운데글자가져오기 {
    class Solution {
        public String solution(String s) {
            int i = s.length() / 2;
            if (s.length() % 2 == 0) {
                return s.substring(i - 1, i + 1);
            } else {
                return s.substring(i, i + 1);
            }
        }
    }
}
