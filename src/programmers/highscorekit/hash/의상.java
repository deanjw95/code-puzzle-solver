package src.programmers.highscorekit.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class 의상 {
    class Solution {
        public int solution(String[][] clothes) {

            Map<String, Integer> map = new HashMap<>();

            for (String[] clothe : clothes) {
                map.put(clothe[1], map.getOrDefault(clothe[1], 0) + 1);
            }

            AtomicInteger answer = new AtomicInteger(1);
            map.forEach((key, value) -> answer.updateAndGet(v -> v * (value + 1)));
            return answer.get() - 1;
        }
    }


    /*
    * */
}
