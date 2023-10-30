package src.programmers.lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 일차다트게임 {
    class Solution {
        public int solution(String dartResult) {
            int answer = 0;
            List<Integer> list = new ArrayList<>();
            String[] split = dartResult.split("(?<=\\D)");

            for (String s : split) {
                if (s.matches(".*[SDT]")) {
                    int num = Integer.parseInt(s.substring(0, s.length() - 1));
                    int pow = switch (s.charAt(s.length() - 1)) {
                        case 'S' -> 1;
                        case 'D' -> 2;
                        case 'T' -> 3;
                        default -> 0;
                    };
                    list.add((int) Math.pow(num, pow));
                } else if (s.matches(".*[*#]")) {
                    int num = 0;
                    if (list.size() == 1) {
                        switch (s) {
                            case "*":
                                list.set(0, list.get(0) * 2);
                                break;
                            case "#":
                                list.set(0, list.get(0) * -1);
                                break;
                        }
                    } else {
                        switch (s) {
                            case "*":
                                list.set(list.size() - 1, list.get(list.size() - 1) * 2);
                                list.set(list.size() - 2, list.get(list.size() - 2) * 2);
                                break;
                            case "#":
                                list.set(list.size() - 1, list.get(list.size() - 1) * -1);
                                break;
                        }
                    }
                }
            }

            for (Integer integer : list) {
                answer += integer;
            }

            return answer;
        }
    }
}
