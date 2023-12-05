package src.programmers.lv2;

import java.util.Stack;

public class 택배배달과수거하기 {
    class Solution {
        public long solution(int cap, int n, int[] deliveries, int[] pickups) {
            long answer = n * 2L;
            Stack<Integer> deliveriesStack = new Stack<>();
            Stack<Integer> pickupsStack = new Stack<>();
            for (int i = 0; i < n; i++) {
                deliveriesStack.push(deliveries[i]);
                pickupsStack.push(pickups[i]);
            }

            int deliveryNow = 0;
            int pickupNow = 0;

            while (!deliveriesStack.isEmpty() || !pickupsStack.isEmpty()) {
                if (!deliveriesStack.isEmpty()) {
                    deliveryNow += deliveriesStack.pop();
                }
                if (!pickupsStack.isEmpty()) {
                    pickupNow += pickupsStack.pop();
                }

                if (deliveryNow > cap) {
                    deliveriesStack.push(deliveryNow - cap);
                    answer += Math.max(deliveriesStack.size(), pickupsStack.size()) * 2L;
                    deliveryNow = 0;
                    pickupNow = 0;
                }

                if (pickupNow > cap) {
                    pickupsStack.push(pickupNow - cap);
                    answer += Math.max(deliveriesStack.size(), pickupsStack.size()) * 2L;
                    deliveryNow = 0;
                    pickupNow = 0;
                }
            }

            return answer;
        }

    }

    class Solution2 {
        public long solution(int cap, int n, int[] deliveries, int[] pickups) {
            long answer = 0;
            //트럭 하나로 모든 배달과 수거를 마치고 물류창고까지 돌아올 수 있는 최소 이동 거리를 return

            int d = 0;
            int p = 0;
            for(int i=n-1; i>=0; i--){
                d -= deliveries[i];
                p -= pickups[i];

                while(d < 0 || p < 0){
                    d += cap;
                    p += cap;
                    answer += (i+1)*2;
                }
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        int cap = 3;
        int n = 5;
        int[] deliveries = {1, 2, 3, 4, 5};
        int[] pickups = {1, 2, 3, 4, 5};
        System.out.println(new 택배배달과수거하기().new Solution().solution(cap, n, deliveries, pickups));
    }


    /*
    * */
}
