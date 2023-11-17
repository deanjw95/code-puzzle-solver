package programmers.lv1;

import java.util.HashMap;
import java.util.Map;

public class 덧칠하기 {

    class Solution {
        public int solution(int n, int m, int[] section) {
            int start = section[0];
            int end = section[0] + (m - 1);
            int ans = 1;

            for (int i : section) {
                if (i >= start && i <= end)
                    continue;
                else {
                    start = i;
                    end = i + (m - 1);
                    ans++;
                }

            }
            return ans;
        }
    }
        // 페인트를 칠하는 구역이 바깥으로 벗어나면 안되는줄 암. 된다고 했을때 가정하면 쉬워짐
}


