package src.programmers.lv1;

import java.util.Stack;

public class 부족한금액계산하기 {

    class Solution {
        public long solution(int price, int money, int count) {
            long sum = 0;
            for (int i = 1; i <= count; i++) {
                sum += i;
            }
            return sum * price - money > 0 ? sum * price - money : 0;
        }
    }

    class Solution2 {
        public long solution(long price, long money, long count) {
            return Math.max(price * (count * (count + 1) / 2) - money, 0);
        }
    }
}
