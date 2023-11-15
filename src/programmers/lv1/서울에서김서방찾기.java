package src.programmers.lv1;

import java.util.Arrays;
import java.util.List;

public class 서울에서김서방찾기 {
    class Solution {
        public String solution(String[] seoul) {
            List<String> list = Arrays.asList(seoul);
            int index = list.indexOf("Kim");
            return "김서방은 " + index + "에 있다";
        }
    }
}
