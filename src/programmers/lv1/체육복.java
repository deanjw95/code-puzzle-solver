package src.programmers.lv1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 체육복 {
    class Solution {
        public int solution(int n, int[] lost, int[] reserve) {
            int answer = n - lost.length;
            List<Integer> lostList = new ArrayList<>();
            List<Integer> reserveList = new ArrayList<>();

            for (int k : lost) {
                lostList.add(k);
            }

            for (int j : reserve) {
                reserveList.add(j);
            }
            lostList.sort(null);
            reserveList.sort(null);

            for (int i = 0; i < lostList.size(); i++) {
                if (reserveList.contains(lostList.get(i))) {
                    answer++;
                    reserveList.remove(reserveList.indexOf(lostList.get(i)));
                }
                if (reserveList.contains(lostList.get(i) - 1)) {
                    answer++;
                    reserveList.remove(reserveList.indexOf(lostList.get(i) - 1));
                } else if (reserveList.contains(lostList.get(i) + 1)) {
                    answer++;
                    reserveList.remove(reserveList.indexOf(lostList.get(i) + 1));
                }
            }

            return answer;
        }
    }

    class Solution2 {
        public int solution(int n, int[] lost, int[] reserve) {
            int[] people = new int[n];
            int answer = n;

            for (int l : lost)
                people[l-1]--;
            for (int r : reserve)
                people[r-1]++;

            for (int i = 0; i < people.length; i++) {
                if(people[i] == -1) {
                    if(i-1>=0 && people[i-1] == 1) {
                        people[i]++;
                        people[i-1]--;
                    }else if(i+1< people.length && people[i+1] == 1) {
                        people[i]++;
                        people[i+1]--;
                    }else
                        answer--;
                }
            }
            return answer;
        }
    }
}
