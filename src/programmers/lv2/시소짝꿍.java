package src.programmers.lv2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 시소짝꿍 {
    class Solution {
        public long solution(int[] weights) {
            long answer = 0;
            Arrays.sort(weights);

            for (int i = 0; i < weights.length - 1; i++) {
                for (int j = i + 1; j < weights.length; j++) {
                    if (weights[i] == weights[j]) {
                        answer++;
                    }

                    int gcd = findLCM(weights[i], weights[j]);
                    int i1 = gcd / weights[i];
                    int i2 = gcd / weights[j];

                    if (i1 * i2 == 2) {
                        answer++;
                    }

                    if (1 < i1 && i1 < 5 && 1 < i2 && i2 < 5) {
//                        System.out.println(weights[i] + " " + weights[j] + " " + i1 + " " + i2 + " " + gcd);
                        answer++;
                    }
                }
            }
            return answer;
        }

        // 최대공약수(GCD)를 계산하는 메서드
        private static int findGCD(int a, int b) {
            while (b != 0) {
                int temp = b;
                b = a % b;
                a = temp;
            }
            return a;
        }

        // 최소공배수(LCM)를 계산하는 메서드
        private static int findLCM(int a, int b) {
            // 최소공배수 = 두 수의 곱 / 최대공약수
            return (a * b) / findGCD(a, b);
        }
        /*
         * */
    }

    class Solution2 {
        public long solution(int[] weights) {
            long answer = 0;
            Arrays.sort(weights);
            Map<Double, Integer> map = new HashMap<>();
            for(int i : weights) {
                double a = i*1.0;
                double b = (i*2.0)/3.0;
                double c = (i*1.0)/2.0;
                double d = (i*3.0)/4.0;
                if(map.containsKey(a)) answer += map.get(a);
                if(map.containsKey(b)) answer += map.get(b);
                if(map.containsKey(c)) answer += map.get(c);
                if(map.containsKey(d)) answer += map.get(d);
                map.put((i*1.0), map.getOrDefault((i*1.0), 0)+1);
            }

            return answer;
        }
    }
}
