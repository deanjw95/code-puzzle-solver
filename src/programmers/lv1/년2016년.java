package src.programmers.lv1;

import java.time.LocalDate;

public class 년2016년 {
    class Solution {
        public String solution(int a, int b) {
            LocalDate date = LocalDate.of(2016, a, b);
            return date.getDayOfWeek().toString().substring(0, 3);
        }
    }
}
