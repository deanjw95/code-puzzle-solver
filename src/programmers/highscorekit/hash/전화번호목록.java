package src.programmers.highscorekit.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 전화번호목록 {
    class Solution {
        public boolean solution(String[] phone_book) {
            boolean answer = true;

            Arrays.sort(phone_book);

            for (int i = 0; i < phone_book.length; i++) {
                for (int j = i + 1; j < phone_book.length; j++) {
                    if (phone_book[j].startsWith(phone_book[i])) {
                        return false;
                    }
                }
            }

            return answer;
        }
    }

    class Solution2 {
        public boolean solution(String[] phone_book) {
            Map<String, Integer> map = new HashMap<>();

            for (String phone : phone_book) {
                map.put(phone, 1);
            }

            for (String phone : phone_book) {
                for (int i = 1; i < phone.length(); i++) {
                    if (map.containsKey(phone.substring(0, i))) {
                        return false;
                    }
                }
            }

            return true;
        }
    }


    /*
     * */
}
