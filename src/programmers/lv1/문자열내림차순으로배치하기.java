package src.programmers.lv1;

import java.util.Arrays;

public class 문자열내림차순으로배치하기 {
    class Solution {
        public String solution(String s) {
            char[] chars = s.toCharArray();

            for (int i = 0; i < s.length() - 1; i++) {
                for (int j = i; j < s.length(); j++) {
                    if (chars[i] < chars[j]) {
                        char temp = chars[i];
                        chars[i] = chars[j];
                        chars[j] = temp;
                    }
                }
            }

            return String.valueOf(chars);
        }
    }

    public class ReverseStr {
        public String reverseStr(String str){
            char[] sol = str.toCharArray();
            Arrays.sort(sol);
            return new StringBuilder(new String(sol)).reverse().toString();
        }
    }
}
