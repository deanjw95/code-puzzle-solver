package src.programmers.lv1;

public class 문자열내마음대로정렬하기 {
    class Solution {
        public String[] solution(String[] strings, int n) {
            for (int i = 0; i < strings.length - 1; i++) {
                for (int j = i; j < strings.length; j++) {
                    if (strings[i].charAt(n) > strings[j].charAt(n)) {
                        String temp = strings[i];
                        strings[i] = strings[j];
                        strings[j] = temp;
                    } else if (strings[i].charAt(n) == strings[j].charAt(n)) {
                        if (strings[i].compareTo(strings[j]) > 0) {
                            String temp = strings[i];
                            strings[i] = strings[j];
                            strings[j] = temp;
                        }
                    }
                }
            }

            return strings;
        }
    }
}
