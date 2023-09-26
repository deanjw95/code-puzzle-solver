package src.programmers.lv1;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 개인정보수집유효기간 {

    class Solution {
        public int[] solution(String today, String[] terms, String[] privacies) {
            List<Integer> answer = new ArrayList<>();

            // today를 . 으로 split
            String[] todaySplit = today.split("\\.");
            int todayYear = Integer.parseInt(todaySplit[0]);
            int todayMonth = Integer.parseInt(todaySplit[1]);
            int todayDay = Integer.parseInt(todaySplit[2]);
            LocalDateTime todayLocalDateTime = LocalDateTime.of(todayYear, todayMonth, todayDay, 0, 0);

            Map<String, Integer> termsMap = new HashMap<>();
            for (String term : terms) {
                String[] split = term.split(" ");
                termsMap.put(split[0], Integer.parseInt(split[1]));
            }

            for (int i = 0; i < privacies.length; i++) {
                String[] privacy = privacies[i].split(" ");
                String[] endDaySplit = privacy[0].split("\\.");
                int endYear = Integer.parseInt(endDaySplit[0]);
                int endMonth = Integer.parseInt(endDaySplit[1]);
                int endDay = Integer.parseInt(endDaySplit[2]);
                int addMonth = termsMap.get(privacy[1]);

                if (endMonth + addMonth > 12) {
                    endYear += (endMonth + addMonth) / 12;
                    endMonth = (endMonth + addMonth) % 12;
                } else {
                    endMonth += addMonth;
                }

                LocalDateTime localDateTime = LocalDateTime.of(endYear, endMonth, endDay, 0, 0);

                System.out.println("localDateTime = " + localDateTime + ", todayLocalDateTime = " + todayLocalDateTime);
                if (localDateTime.isBefore(todayLocalDateTime) || localDateTime.isEqual(todayLocalDateTime)) {
                    answer.add(i + 1);
                }
            }

            return answer.stream().mapToInt(Integer::intValue).toArray();
        }
    }

    class Solution2 {
        public int[] solution(String today, String[] terms, String[] privacies) {
            ArrayList<Integer> answer = new ArrayList<>();
            HashMap<String, Integer> map = new HashMap<>();

            int date = getDate(today);

            for (String s : terms) {
                String[] term = s.split(" ");
                map.put(term[0], Integer.parseInt(term[1]));
            }

            for (int i = 0; i < privacies.length; i++) {
                String[] privacy = privacies[i].split(" ");

                if (getDate(privacy[0]) + (map.get(privacy[1]) * 28) <= date) {
                    answer.add(i + 1);
                }
            }
            return answer.stream().mapToInt(integer -> integer).toArray();
        }

        private int getDate(String today) {
            String[] date = today.split("\\.");
            int year = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int day = Integer.parseInt(date[2]);
            return (year * 12 * 28) + (month * 28) + day;
        }
    }

}
